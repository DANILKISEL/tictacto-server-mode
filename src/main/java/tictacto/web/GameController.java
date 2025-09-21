package tictacto.web;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.stereotype.Controller;
import tictacto.web.GameState;


@Controller
@EnableWebSocketMessageBroker
public class GameController {

    private final GameState game = new GameState();

    @MessageMapping("/move")
    @SendTo("/topic/game")
    public GameState processMove(Move move) {
        game.makeMove(move.getX(), move.getY(), move.getPlayer());
        return game;
    }
}
