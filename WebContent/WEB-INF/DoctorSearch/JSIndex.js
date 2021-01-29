$(document).ready(function(){

    $( "#showMoreBtn" ).click(function(event){
        var btnText = document.getElementById("showMoreBtn");
        if (btnText.innerHTML === "Afficher moins") {
            btnText.innerHTML = "Afficher plus"; 
            $("#showMore").slideToggle();
        } else {
            btnText.innerHTML = "Afficher moins"; 
            $("#showMore").slideToggle();
        }
    });

    $( "#showSearchBarBtn" ).click(function(event){
        $("#search_bar").slideToggle();
    });
    
    $( "#clearAllBtn" ).click(function(event){
        $('#NameInput').val('');
        $('#Telemedecine').prop( "checked", true );
        $('#Consultation_a_domicile').prop( "checked", true );
        $('.Rating #Tous').prop( "checked", true );
        $('.Speciality #Tous').prop( "checked", true );
        $('.Language #Tous').prop( "checked", true );
        $('.Gender #Tous').prop( "checked", true );
        filter();
    });

    $(window).resize(function() {
        if($("#search_bar").is(':hidden') && $( document ).width() > 960){
            $("#search_bar").slideToggle();
        }
    });
});

function filter() {

    var items = document.getElementsByClassName('item');

    for(var i = 0; i < items.length; i++){
        items[i].style.display = 'none';
    }

    items = filterRadio(items, 'Speciality');
    items = filterRadio(items, 'rating');
    items = filterRadio(items, 'gender');
    items = filterBySevicesSpecial(items);
    items = filterRadio(items, 'Language');
    items = filterByName(items);

    for(var i = 0; i < items.length; i++){
        items[i].style.display = "inline";
    }

    return items;
}

function filterRadio(items, type){
    var type = document.getElementsByName(type);
    var type_id;
    var choosen_items = [];

    for(var i = 0; i < type.length; i++){
        if(type[i].checked){
            type_id = type[i].id;
        }
    }

    if(type_id == 'Tous'){
        return items;
    }else{
        for(var i = 0; i < items.length; i++){
            if(items[i].classList.contains(type_id)){
                choosen_items.push(items[i]);
            }
        }
        return choosen_items;
    }
}

function filterBySevicesSpecial(items) {
    var Sevices_Special = document.getElementsByName('Sevices_Special');
    var Sevices_Special_id = [];
    var choosen_items = [];

    for(var i = 0; i < Sevices_Special.length; i++){
        if(Sevices_Special[i].checked){
            Sevices_Special_id.push(Sevices_Special[i].id);
        }
    }

    if(Sevices_Special_id.length == 2){
        return items;
    }else if(Sevices_Special_id.length == 0){
        for(var i = 0; i < items.length; i++){
            if(!items[i].classList.contains("Telemedecine") && !items[i].classList.contains("Consultation_a_domicile")){
                choosen_items.push(items[i]);
            }
        }
        return choosen_items;
    }else{
        for(var i = 0; i < items.length; i++){
            if(items[i].classList.contains(Sevices_Special_id[0])){
                choosen_items.push(items[i]);
            }
        }
        return choosen_items;
    }
}

function filterByName(items) {
    var NameInput = document.getElementById('NameInput').value;
    var choosen_items = [];

    if(NameInput == ''){
        return items;
    }else{
        for(var i = 0; i < items.length; i++){
            var fullName = items[i].getElementsByClassName('fullName');
            if(fullName[0].innerHTML.toLowerCase().includes(NameInput.toLowerCase())){
                choosen_items.push(items[i]);
            }
        }
        return choosen_items;
    }
}
