yieldUnescaped '<!DOCTYPE html>'
html {
    head {
        title("Hello as a Service")
        meta(name: 'viewport', content: 'width=device-width, initial-scale=1.0')
        link(rel: 'stylesheet', media: 'screen', href: '/webjars/foundation/5.5.2/css/foundation.css')
        script(src: "/webjars/angularjs/1.4.3-1/angular.js"){yield ""}
        script(src: "/static/js/app.js") {yield ""}
    }

    body('ng-app': "haas") {

        div(class: "row") {
            h1("Hello as a Service")
            mainBody()
        }
    }
}