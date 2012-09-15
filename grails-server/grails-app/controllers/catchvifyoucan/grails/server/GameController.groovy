package catchvifyoucan.grails.server

class GameController {
    def scaffold = true

    def index = {
        redirect(action: "list")
    }
}
