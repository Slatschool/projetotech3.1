import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KitchenGame {

    // Classe interna para armazenar a descrição e opções de cada escolha
    static class Choice {
        String description;
        String[] options;

        Choice(String description, String[] options) {
            this.description = description;
            this.options = options;
        }
    }

    // Mapa de escolhas com suas descrições e opções
    private static final Map<String, Choice> choices = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    static {
        choices.put("Pegar o pão", new Choice(
                "Você pegou o pão. Agora, o que você faz?",
                new String[]{"Pegar o ovo", "Acender o fogão", "Cortar o pão"}
        ));
        choices.put("Pegar o ovo", new Choice(
                "Você pegou o ovo. Agora, o que você faz?",
                new String[]{"Pegar o pão", "Acender o fogão", "Quebrar o ovo na frigideira"}
        ));
        choices.put("Acender o fogão", new Choice(
                "Você acendeu o fogão. Agora, o que você faz?",
                new String[]{"Pegar o pão", "Pegar o ovo", "Colocar uma frigideira no fogão"}
        ));
        choices.put("Cortar o pão", new Choice(
                "Você cortou o pão. Agora, o que você faz?",
                new String[]{"Pegar o ovo", "Acender o fogão", "Colocar o pão na frigideira"}
        ));
        choices.put("Quebrar o ovo na frigideira", new Choice(
                "Você quebrou o ovo na frigideira e começou a cozinhar. Está quase pronto!",
                new String[]{"Acender o fogão", "Torrar o pão", "Servir o pão com ovo"}
        ));
        choices.put("Colocar uma frigideira no fogão", new Choice(
                "Você colocou a frigideira no fogão. Agora, o que você faz?",
                new String[]{"Quebrar o ovo na frigideira", "Cortar o pão", "Pegar o pão"}
        ));
        choices.put("Torrar o pão", new Choice(
                "Você torrou o pão. Agora, está na hora de servir!",
                new String[]{"Servir o pão com ovo"}
        ));
        choices.put("Servir o pão com ovo", new Choice(
                "Parabéns! Você preparou um delicioso pão com ovo!",
                new String[]{"Recomeçar"}
        ));
        choices.put("Recomeçar", new Choice(
                "Você está na cozinha e decidiu preparar um delicioso pão com ovo. O que você faz primeiro?",
                new String[]{"Pegar o pão", "Pegar o ovo", "Acender o fogão"}
        ));
    }

    public static void main(String[] args) {
        String currentChoice = "Recomeçar"; // Inicia com a escolha de recomeçar
        while (true) {
            makeChoice(currentChoice);
            System.out.println("Digite sua escolha:");
            currentChoice = scanner.nextLine();
            if (!choices.containsKey(currentChoice)) {
                System.out.println("Escolha uma ação válida.");
                currentChoice = "Recomeçar"; // Se a escolha for inválida, recomeça
            }
        }
    }

    private static void makeChoice(String choice) {
        Choice currentChoice = choices.getOrDefault(choice, new Choice(
                "Escolha uma ação válida.",
                new String[]{"Pegar o pão", "Pegar o ovo", "Acender o fogão"}
        ));

        System.out.println(currentChoice.description);
        for (int i = 0; i < currentChoice.options.length; i++) {
            System.out.println((i + 1) + ". " + currentChoice.options[i]);
        }
    }
}

