package Restaurant.Complain;

public enum LevelProblem {
    // đợi lâu, thắc mắc giá, thái độ phục vụ, đồ ăn, vệ sinh, ngộ độc, chết người
    LONG_TIME_WAITING(0, "đợi lâu"),
    QUESTION_PRICE(1, "thắc mắc giá"),
    DEPORTMENT(2, "thái độ phục vụ"),
    EATING(3, "đồ ăn"),
    HYGIENE(4, "vệ sinh"),
    POISONING(5, "ngộ độc"),
    FATAL(6, "chết người");

    private int level;
    private String message;


    LevelProblem(int level, String message) {
        this.level = level;
        this.message = message;
    }

    public int getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}
