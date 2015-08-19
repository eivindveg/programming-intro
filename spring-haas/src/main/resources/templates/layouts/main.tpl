yieldUnescaped '<!DOCTYPE html>'

html {
    head {
        title("Hello as a Service")
        link(rel: 'stylesheet', href: '/webjars/foundation/5.5.2/css/foundation.css')
    }

    body {
        div(class: 'row') {
            mainBody()
        }
    }
}