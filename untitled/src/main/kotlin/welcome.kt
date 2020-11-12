import kotlinx.css.img
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.onClick
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.br
import react.dom.div
import react.dom.img
import styled.css
import styled.styledDiv
import styled.styledInput
import kotlinx.browser.window
import kotlinx.css.input
import react.dom.input

external interface WelcomeProps : RProps {
    var name: String
    var password: String
}

class checkStore(id: Int) : RState {
    var id = 0

    init {
        this.id = id

    }

    fun acb(): WelcomeState {
        return WelcomeState("nope", "Notelet")
    }
}

data class WelcomeState(val name: String, val password: String) : RState

@JsExport
class Welcome(props: WelcomeProps) : RComponent<WelcomeProps, WelcomeState>(props) {

    init {
        state = checkStore(props.name.toInt()).acb().toString()
    }

    override fun RBuilder.render() {
        styledDiv {
            css {
                +WelcomeStyles.textContainer
            }
            +"Hello, ${state.name}"

        }
        styledInput {
            css {
                +WelcomeStyles.textInput
            }
            attrs {
                type = InputType.text
                value = 1.toString()
                onChangeFunction = { event ->
                    setState(
                            checkStore(props.name.toInt())
                    )
                }
            }
        }
        div {
            br() {}

        }

        styledInput {
            css {
                +WelcomeStyles.textInput
            }
            attrs {
                type = InputType.button
                value = "Submit"
                onClickFunction = { event ->
                    //setState(
                    //  WelcomeState("",password = (event.target as HTMLInputElement).value)
                    //)
                    window.alert("Welcome")
                }
            }
        }
        div {
            br() {}

        }
        div {
            img(src = "http://placekitten.com/g/200/300") {}
        }
    }
}
