layout 'layouts/main.tpl',
        mainBody: contents {
            div('ng-controller': "HelloController", class: "small-12 columns") {
                div(class: "small-6 medium-4 columns") {
                    select('ng-model': "greeting", 'ng-options': "greeting.label for greeting in greetings") {
                        yield ""
                    }
                }
                div(class: "small-6 medium-4 columns") {
                    input(type: 'text', 'ng-model': 'name')
                }
                div(class: "small-12 medium-4 columns") {
                    a(class: "button success radius expand", 'ng-href': '''/{{greeting.route}}/{{name}}''', "Greet")
                }
            }

        }