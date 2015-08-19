layout 'layouts/main.tpl',
        mainBody: contents {
            div('ng-controller': "HelloController") {
                select('ng-model': "greeting", 'ng-options': "greeting.label for greeting in greetings") {
                    yield ""
                }
                input(type: 'text', 'ng-model': 'name')
                a(class: "button success radius", 'ng-href': '''/{{greeting.route}}/{{name}}''', "Greet")
            }

        }