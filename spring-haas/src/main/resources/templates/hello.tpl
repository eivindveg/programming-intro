layout 'layouts/main.tpl',
        mainBody: contents {
            h2("Hello, $name")
            a(href:"/", "Go home")
        }