package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();
        for (String url : this.urls) {
            boolean isValid = true;
            for (int j = 0; j < url.length(); j++) {
                if (Character.isDigit(url.charAt(j))) {
                    isValid = false;
                }
            }
            if (isValid) {
                result.append("Browsing: ").append(url).append("!");
            } else {
                result.append("Invalid URL!");
            }
            result.append(System.lineSeparator());
        }

        return result.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();
        for (String number : this.numbers) {
            boolean isValid = true;
            for (int j = 0; j < number.length(); j++) {
                if (!Character.isDigit(number.charAt(j))) {
                    isValid = false;
                }
            }
            if (isValid) {
                result.append("Calling... ").append(number);
            } else {
                result.append("Invalid number!");
            }
            result.append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
