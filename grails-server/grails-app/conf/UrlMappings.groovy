class UrlMappings {

	static mappings = {
        "/api/game"{
            controller = "game"
            action = [GET: "games", POST: "createGame"]
        }
        "/api/game/$gameId"{
            controller ="game"
            action = "game"
        }
        "/api/game/$gameId/$playerId"{
            controller = "player"
            action = [GET: "trail", PUT: "createPlayer", POST: "addLocation"]
        }
        "/api/game/$gameId/$playerId/$locationIndex"{
            controller = "player"
            action = "location"
        }
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }


        "/"(view:"/index")
		"500"(view:'/error')
	}
}
