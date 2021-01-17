
const navSlide=()=> {
    const burger = document.querySelector('.burger');
    const navbar = document.querySelector('.nav-links' );
    const navLinks = document.querySelectorAll('.nav-links li');
    
    burger.addEventListener('click',()=>{
        //toggle the navbar
        navbar.classList.toggle('nav-active');
        //links animation 
        navLinks.forEach((link ,index)=>{
           if( link.style.animation){
            link.style.animation = ``;
           }
           else{
            link.style.animation = `navLinkFade 0.5s ease forwards ${index / 7+0.5}s`;
           }
        });
        // burger animation 
        burger.classList.toggle('toggle');
    });

}
 navSlide();