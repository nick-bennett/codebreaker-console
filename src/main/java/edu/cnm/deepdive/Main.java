package edu.cnm.deepdive;

import edu.cnm.deepdive.controller.Player;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    // TODO: Read command-line arguments for game difficulty.
    try (Scanner scanner = new Scanner(System.in)) {
      Player player = new Player(scanner, System.out);
      player.play("ABCDEF", 3);
    }
  }

}
