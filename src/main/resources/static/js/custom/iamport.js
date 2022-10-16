
function requestPay() {

    // let amountPrice = Number(document.querySelector("#totalPrice").innerText);
    // console.log(amountPrice);


    window.IMP.init('imp73826618');
    window.IMP.request_pay({
        pg: "kcp",
        pay_method: "card",
        merchant_uid : merchant_uid,
        name : name,
        // amount : amount,
        amount : 1,
        buyer_email : buyer_email,
        buyer_name : buyer_name,
        buyer_tel : buyer_tel,
        buyer_addr : buyer_addr,
        buyer_postcode : buyer_postcode,
    }, function (rsp) { // callback
        if (rsp.success) {
            alert("결제 성공")
        } else {
            alert("실패!!!!!!!!!!!!!!!!!!!")
        }
    });
}