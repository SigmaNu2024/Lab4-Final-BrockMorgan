import java.util.List;
import java.util.stream.Collectors;


public class OscarAwardFilter
{
    public enum FilterType{
        CATEGORY,
        YEAR,
        CEREMONY_YEAR
    }

    public List<OscarAward> filter (List<OscarAward> awards, FilterType filterType, String filterValue){
        switch (filterType){
            case CATEGORY:
                return filterByCategory(awards, filterValue);
            case YEAR:
                return filterByYear(awards, Integer.parseInt(filterValue));
            case CEREMONY_YEAR:
                return filterByCeremonyYear(awards, Integer.parseInt(filterValue));
            default:
                throw new IllegalArgumentException("Invalid filter type");
        }
    }
    public List<OscarAward> filterByCategory(List<OscarAward> awards, String category)
    {
        return awards.stream()
                .filter(award -> award.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<OscarAward> filterByYear(List<OscarAward> awards, int yearFilm) {
        return awards.stream()
                .filter(award ->award.getYearFilm() == yearFilm)
                .collect(Collectors.toList());
    }

    public List<OscarAward> filterByCeremonyYear(List<OscarAward> awards, int yearCeremony) {
        return awards.stream()
                .filter(award -> award.getYearCeremony() == yearCeremony)
                .collect(Collectors.toList());
    }
}
