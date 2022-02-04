package edu.cnm.deepdive.controller;

import edu.cnm.deepdive.model.Game;
import edu.cnm.deepdive.model.Guess;
import edu.cnm.deepdive.service.GameRepository;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Player {

  private final GameRepository repository;
  private final Scanner scanner;
  private final PrintStream output;

  public Player(Scanner scanner, PrintStream output) {
    this.scanner = scanner;
    this.output = output;
    repository = new GameRepository();
  }

  public void play(String pool, int length) throws IOException {
    Game game = repository.startGame(pool, length);
    do {
      String input = getGuess(game);
      Guess guess = repository.submitGuess(game, input);
      displayOutcome(guess);
    } while (!game.isSolved());
    // TODO: Display ending summary.
  }

  private String getGuess(Game game) throws IOException {
    output.printf("Pool: \"%s\"; length: %d.%nEnter guess: ", game.getPool(), game.getLength());
    String input = scanner
        .nextLine()
        .trim();
    // TODO: Validate input using the pool and length.
    return input;
  }

  private void displayOutcome(Guess guess) {
    output.printf("Exact matches: %d; near matches: %d.%n", guess.getExactMatches(), guess.getNearMatches());
    // TODO: Include appropriate indicator if solved.
  }

}
