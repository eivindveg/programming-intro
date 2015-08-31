layout 'layouts/main.tpl',
        mainBody: contents {
            h2("$name, you are my hero")
            img(src: "/static/img/hero.jpg")
            a(href:"/", "Go home")
        }