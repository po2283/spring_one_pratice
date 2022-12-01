package core.pratice.Card;

//카드의 기본 정보
public class Card {
    //카드 id, 카드 이름, 카드 종류

    private Long id;
    private String name;
    private Series series;

    public Card(Long id, String name, Series series) {
        this.id = id;
        this.name = name;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }
}
