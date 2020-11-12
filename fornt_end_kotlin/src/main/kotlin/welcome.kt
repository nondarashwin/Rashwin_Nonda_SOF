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
import styled.css
import styled.styledDiv
import styled.styledInput
import kotlinx.browser.window
import react.dom.*

external interface WelcomeProps : RProps {

    var storeName: String
    var storeAddress: String
}

class WelcomeState(var storeName: String, var storeAddress: String) : RState{
    private var Name:String=""
    private var Address:String=""
    init {
        this.Name=storeName
        this.Address=storeAddress
    }
    fun operation(){


    }
}

@JsExport
class Welcome(props: WelcomeProps) : RComponent<WelcomeProps, WelcomeState>(props) {
    init {
        state = WelcomeState( props.storeName, props.storeAddress)
    }

    override fun RBuilder.render() {
        styledDiv {
            css {
                +WelcomeStyles.textContainer
            }
            +"Add store"
        }

        div {

        }
        div {
            br() {}
        }
        styledInput {
            css {
                +WelcomeStyles.textInput
            }
            attrs {
                type = InputType.text
                value = state.storeName
                onChangeFunction = { event ->
                    setState(
                            WelcomeState((event.target as HTMLInputElement).value,state.storeAddress)
                    )
                }
            }
        }
        div { br(){

        } }
        styledInput {
            css {
                +WelcomeStyles.textInput
            }
            attrs {
                type = InputType.text
                value = state.storeAddress
                onChangeFunction = { event ->
                    setState(
                            WelcomeState(state.storeName,(event.target as HTMLInputElement).value)
                    )
                }
            }
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

                }
            }
        }
        div {
            br() {}
        }

    }
}