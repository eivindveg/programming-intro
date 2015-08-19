layout 'layouts/main.tpl',
        mainBody: contents {
            div {
                h2("$name, you are my hero!")
                img(src: "/static/img/hero.jpg")
            }
        }