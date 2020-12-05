import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.*
import styled.css
import styled.styledDiv
import styled.styledInput

external interface WelcomeProps : RProps {
    var name: String
}

@JsExport
val welcome = functionalComponent<WelcomeProps> { props ->
    val (name, setName) = useState(props.name)
    styledDiv {
        css {
            +WelcomeStyles.textContainer
        }
        +"Hello, $name"
    }
    styledInput {
        css {
            +WelcomeStyles.textInput
        }
        attrs {
            type = InputType.text
            value = name
            onChangeFunction = { event ->
                setName((event.target as HTMLInputElement).value)
            }
        }
    }
}
