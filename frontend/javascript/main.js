let counter=0
function increment(){
    counter++;
    displayCounterToUI();

}
function decrement(){
    counter--;
    displayCounterToUI()
}

function displayCounterToUI(){

    let ele=document.getElementById('a');
    //to add contetn we will us einner html
    ele.innerHTML='Counter='+counter;

}
