package donquih0te;

import java.util.Objects;

public class CurrentChangelogDisplay implements Observer {

    private String title;
    private String url;
    private Changelog changelog;

    public CurrentChangelogDisplay(Changelog changelog) {
        this.changelog = changelog;
        changelog.registerObserver(this);
    }

    @Override
    public void update(String title, String url) {
        if(!(Objects.equals(this.url, url)) && !(Objects.equals(this.title, title))) {
            this.title = title;
            this.url = url;
            System.out.println("Новый снапшот: " + title + "\n" + url);
        }
    }
}
