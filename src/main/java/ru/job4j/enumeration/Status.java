package ru.job4j.enumeration;

public enum Status {

    ACCEPTED("Принят") {
        private String message = "Автомобиль принят на СТО";

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return super.toString()
                    + ", message='" + message + '\''
                    + '}';
        }
    },
    IN_WORK("В работе") {
        private String message = "Автомобиль в работе";

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return super.toString()
                    + ", message='" + message + '\''
                    + '}';
        }
    },
    WAITING("Ожидание") {
        private String message = "Автомобиль ожидает запчасти";

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return super.toString()
                    + ", message='" + message + '\''
                    + '}';
        }
    },
    FINISHED("Работы завершены") {
        private String message = "Все работы завершены";

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return super.toString()
                    + ", message='" + message + '\''
                    + '}';
        }
    };

    private String info;

    Status(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public abstract String getMessage();

    @Override
    public String toString() {
        return "Status{"
                + "info='" + info + '\''
                + '}';
    }
}
