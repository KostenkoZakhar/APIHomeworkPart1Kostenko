package models.exchanges;

public enum Currencies {

        CC1("EUR"),
        CC2("USD"),
        CC3("CAD"),
        CC4("GBP"),
        CC5("AUD");

        private final String nationalCurrency;

    Currencies(String number) {
            this.nationalCurrency = number;
        }

        public String getNationalCurrency() {
            return nationalCurrency;
        }

}
