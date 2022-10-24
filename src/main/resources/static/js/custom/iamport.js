
/* iamport 결제 요청 */
const requestPay = () => {

    const buyer_name = document.querySelector(`#name`).value;
    const buyer_tel = document.querySelector(`#tel`).value;

    console.log(buyer_name)
    console.log(buyer_tel)

    window.IMP.init('imp73826618');
    window.IMP.request_pay({
        pg: "kcp",
        pay_method: pay_method,
        merchant_uid : merchant_uid,
        name : name,
        amount : amount,
        // amount : 1,
        buyer_email : buyer_email,
        buyer_name : buyer_name,
        buyer_tel : buyer_tel,
        buyer_addr : buyer_addr,
        buyer_postcode : buyer_postcode,
    }, function (rsp) { // callback
        if (rsp.success) {
            successRequest(rsp.merchant_uid);
        } else {
            alert("실패!!!!!!!!!!!!!!!!!!!")
        }
    });
}

//성공시 실행할 함수
const successRequest = (merchant_uid) => {
//    조금 더 보안을 지켜서 만들면 아임포트 webhook을 사용해서 이중?체크로
//    결제 정보 서버로 요청

    const successForm = document.querySelector("form[name='myForm']");

    const hiddenField = document.createElement('input');

    hiddenField.setAttribute('type', 'hidden'); //값 입력
    hiddenField.setAttribute('name', 'merchantId');
    hiddenField.setAttribute('value', merchant_uid);
    successForm.appendChild(hiddenField);

    successForm.action = '/orders/paymentSuccess';
    successForm.submit();
}

const cancelConfirm = (ordersNum) => {
    confirm("정말 취소하시겠습니까?" + ordersNum + "pk") && runCancel(ordersNum);
}

// const runCancel = (ordersNum) =>{
//     alert("삭제되었습니다.")
//     location.href="/orders/deleteorders/" + ordersNum;
//
//     const form = document.createElement('form');
//
//     form.setAttribute('method', 'post'); //POST 메서드 적용
//     form.setAttribute('action', "/orders/deleteorders/");	// 데이터를 전송할 url
//     const hiddenField = document.createElement('input');
//     hiddenField.setAttribute('type', 'hidden'); //값 입력
//     hiddenField.setAttribute('name', 'ordersNum');
//     hiddenField.setAttribute('value', ordersNum);
//     form.appendChild(hiddenField);
//     document.body.appendChild(form);
//     form.submit();	// 전송~
// }

// function cancelPay() {
//
//     const merchantId = document.querySelector("#merchantId");
//     console.log(merchantId);
//
//     jQuery.ajax({
//         "url": "/deleteorders", // 예: http://www.myservice.com/payments/cancel
//         "type": "POST",
//         "contentType": "application/json",
//         "data": JSON.stringify({
//             "merchant_uid": "{결제건의 주문번호}", // 예: ORD20180131-0000011
//             "cancel_request_amount": 2000, // 환불금액
//             "reason": "테스트 결제 환불", // 환불사유
//             "refund_holder": "홍길동", // [가상계좌 환불시 필수입력] 환불 수령계좌 예금주
//             "refund_bank": "88", // [가상계좌 환불시 필수입력] 환불 수령계좌 은행코드(예: KG이니시스의 경우 신한은행은 88번)
//             "refund_account": "56211105948400" // [가상계좌 환불시 필수입력] 환불 수령계좌 번호
//         }),
//         "dataType": "json"
//     });
// }

///////////////////////////************************
///////////////////////////************************
///////////////////////////************************
///////////////////////////************************
///////////////////////////************************

const runCancel = (ordersNum) =>{
    const merchantId = document.querySelector("#merchantId").value;
    const totalPrice = document.querySelector("#totalPrice").value;

    var header = $("meta[name='_csrf_header']").attr('content');
    var token = $("meta[name='_csrf']").attr('content');

    $.ajax({
        type: "POST",
        url: "/orders/deleteorders",
        contentType: 'application/json; charset=utf-8',
        dataType: "json",
        data: JSON.stringify({
            ordersNum: ordersNum,
            merchant_uid: merchantId,
            cancel_request_amount: totalPrice,
            reason: "테스트 결제 환불",
        }),
        beforeSend: function(xhr){
            xhr.setRequestHeader(header, token);
        },
    }).done((response) => {
        alert(response.merchant_uid);
        alert("성공")
    }).fail(function (error){
        alert("실패")
        alert(JSON.stringify(error));
    });
}


function cancelPay() {


}


