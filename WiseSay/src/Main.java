import java.util.*;

class Quote {
    int id;
    String content;
    String author;

    Quote(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
}

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Quote> quotes = new ArrayList<>();
    static int nextId = 1;

    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                register();
            } else if (command.equals("목록")) {
                listQuotes();
            } else if (command.startsWith("삭제?id=")) {
                deleteQuote(command);
            } else if (command.startsWith("수정?id=")) {
                editQuote(command);
            } else {
                System.out.println("올바르지 않은 명령입니다.");
            }
        }
    }

    static void register() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        Quote quote = new Quote(nextId++, content, author);
        quotes.add(quote);
        System.out.println(quote.id + "번 명언이 등록되었습니다.");
    }

    static void listQuotes() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = quotes.size() - 1; i >= 0; i--) {
            Quote q = quotes.get(i);
            System.out.println(q.id + " / " + q.author + " / " + q.content);
        }
    }

    static void deleteQuote(String command) {
        int id = Integer.parseInt(command.replace("삭제?id=", ""));
        for (int i = 0; i < quotes.size(); i++) {
            if (quotes.get(i).id == id) {
                quotes.remove(i);
                System.out.println(id + "번 명언이 삭제되었습니다.");
                return;
            }
        }
        System.out.println(id + "번 명언은 존재하지 않습니다.");
    }

    static void editQuote(String command) {
        int id = Integer.parseInt(command.replace("수정?id=", ""));
        for (Quote q : quotes) {
            if (q.id == id) {
                System.out.println("명언(기존) : " + q.content);
                System.out.print("명언 : ");
                q.content = scanner.nextLine();

                System.out.println("작가(기존) : " + q.author);
                System.out.print("작가 : ");
                q.author = scanner.nextLine();

                return;
            }
        }
        System.out.println(id + "번 명언은 존재하지 않습니다.");
    }
}
