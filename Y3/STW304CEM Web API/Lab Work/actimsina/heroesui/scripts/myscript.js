$(function () {
    let heroesul = $('$heroes');

    $.ajax({
        type: 'GET',
        url: 'http//localhost:3000/heroes',
        success: function (heroes) {
            console.log(heroes);
            $.each(heroes, function (index, hero) {
                console.log(hero);
            })
            heroesul.append("<li>" + hero.name, ", " + hero.desc + "</li>");
        },
        error: function () {
            alert('Couldnt get heroes');
        }
    })

    $("#add-hero").on('clicl', function () {
        let hero = {
            name: $('#name').val(),
            desc: $('#desc').val()
        };

        $.ajax({
            type: 'POST',
            url: 'http//localhost:3000/heroes',
            data: hero,
            success: function (hero) {
                heroesul.appe
            }, error: function () {
                heroesul.append("<li>" + hero.name, ", " + hero.desc + "</li>");
            }
        }
        })
})
});