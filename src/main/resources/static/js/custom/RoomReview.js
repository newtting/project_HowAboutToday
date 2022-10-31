const ratingStar = document.querySelectorAll("input[name='ratingStar']");
const reviewWrite = document.querySelector("#reviewWrite");
let clickRate = 1;

ratingStar.forEach((star) => {
    star.addEventListener('click', (event) => {
        clickRate = event.target.value;
        console.log(clickRate);
        console.log(star.checked);

        const innerRatingStar = document.querySelectorAll("input[name='ratingStar']");
        innerRatingStar.forEach((star) => {
            if(star.value <= clickRate){
                star.checked = true;
            }
            else {
                star.checked = false;
            }
        });
    })
})

reviewWrite.addEventListener('click', (event) => {
    const reviewMemberName = document.querySelector("#reviewMemberName");
    const reviewContent = document.querySelectorAll("textarea[name='reviewContent']")[0];

    const name = reviewMemberName.value;
    const content = reviewContent.value;

    if(name === "" || content === ""){
        alert("성함과 내용을 작성해주세요.")
        return;
    }
    const data = {
        name: name,
        content: content
    }

    fetch("/roomReview/save", {
        method: 'post',
        headers : {
            'Content-Type' : 'application/json; charset=utf-8'
        },
        body:JSON.stringify(data)
    })
        .then(() => {
            alert("리뷰 저장 성공")
        })
        .catch(() => {
            alert("리뷰 저장 실패");
        })
})

const writeReview = () => {

}