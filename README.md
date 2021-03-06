CatchVifYouCan
==============

This project is an entry for the dutch edition of the 2012 
[V hack Android][1] [Hackathon][2].

> V Hack Android is a community driven series of events to celebrate
> five years of Android developer community with a big tournament on
> 28/29 October in London. The tournament will be a competition
> between user groups for the best applications and developers. The
> final winners will be announced at 5 November 2012.

The Hackathon is held in the weekend of 14th - 15th September at
[Bounce Space][7]

Team
----

Our team is spontanously formed from a group of lone gunners,
i.e. participants without a pre-formed team. The members are

* [Iulia Stana][3]
* [Hans van der Scheer][4]
* [Lorenzo Marchiori][5]
* [Daan van Berkel][6]

App
---

During the hackathon we created the CatchVifYouCan app for
[Android][8]. CatchVifYouCan aims to bring health and (European) Culture into
the minds of its users.

CatchVifYouCan mixes [Scotland Yard][9], [Pac-Man][10] and the [game
of Tag][11] in an hightech innovative gameplay, combining the
capabillities of a modern Android device with the culture of European
cities.
CatchVifYouCan transforms cities into urban playground offering a
unique oppertunity to see a city in a new light and meeting
interesting new people along the way.

API
---

The app connect to a service with a [REST][12]-interface. The following scheme is used.

    Protocol | url                                                             | result
    ---------+-----------------------------------------------------------------+---------------------------------------------------------------------
    GET      | /api/game                                                           | returns a list of game ids
    POST     | /api/game                                                           | creates a new game
    GET      | /api/game/$gameId                                                   | returns a list of player ids in game $id
    GET      | /api/game/$gameId/$playerId                                         | returns the trail of player $playerId in $gameId
    PUT      | /api/game/$gameId/$playerId                                         | registers player $playerId to game $gameId
    POST     | /api/game/$gameId/$playerId?latitude=$latitude&longitude=$longitude | adds a location at $latitude, $longiture for player $playerId in game $gameId
    GET      | /api/game/$gameId/$playerId/$n                                      | retrieve $n-th location in the trail of player $player in game $game

The run below demonstrates how the create a game, adds some players to
the game and update the trail of the players with [cUrl][13]. All the
urls should be prepended with a correct server and endpoint, e.g. http://localhost:8080/server/

    curl -X POST -d "format=json" /api/game  // { "status":"ok" }
    curl -X GET /api/game?format=json        // { "game":[1] }
    curl -X PUT /api/game/1/anna?format=json // { "status":"ok" }
    curl -X PUT /api/game/1/bob?format=json  // { "status":"ok" }
    curl -X GET /api/game/1?format=json      // { "players":["anna","bob"] }
    curl -X POST /api/game/1/anna?longitude=0&latitude=0 // { "status":"ok" }

[1]: http://www.vhackandroid.org/ "The V hack Android page"
[2]: https://plus.google.com/u/0/104578858113292768239/posts "Global Google+ page for the V hack Android events"
[3]: http://www.dutchaug.org/members/31432542/ "Iulia Dutch Android Usergroup profile page"
[4]: http://www.dutchaug.org/members/32087982/ "Hans Dutch Android Usergroup profile page"
[5]: http://www.dutchaug.org/members/24973812/ "Lorenzo Dutch Android Usergroup profile page"
[6]: http://www.dutchaug.org/members/47468802/ "Daan Dutch Android Usergroup profile page"
[7]: http://www.bouncespace.eu "Landing page for the Bounce Space venue"
[8]: http://www.android.com/ "Homepage for Android"
[9]: http://en.wikipedia.org/wiki/Scotland_Yard_%28board_game%29 "Wikipedia on Scotland Yard"
[10]: http://en.wikipedia.org/wiki/Pacman "Wikipedia on Pac-Man"
[11]: http://en.wikipedia.org/wiki/Tag_%28game%29 "Wikipedia on Tag"
[12]: http://en.wikipedia.org/wiki/Representational_state_transfer "Wikipedia on Representational state transfer"
[13]: http://en.wikipedia.org/wiki/CURL "Wikipedia on cUrl"

