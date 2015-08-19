yieldUnescaped '<!DOCTYPE html>'
html {
    head {
        title("Hello as a Service")
        link(rel: 'stylesheet', href: '/webjars/foundation/5.5.2/css/foundation.css')
        script(src: "/webjars/angularjs/1.4.3-1/angular.js"){yield ""}
        script(src: "/static/js/app.js") {yield ""}
    }

    body('ng-app': "haas") {
        div(class: "row") {
            mainBody()
        }
    }
}