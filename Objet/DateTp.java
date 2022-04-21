// 
// Decompiled by Procyon v0.5.36
// 

package Objet;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTp
{
    private int annee;
    private int mois;
    private int jour;
    
    public DateTp(final int a, final int m, final int j) {
        this.annee = a;
        this.mois = m;
        this.jour = j;
    }
    
    public static DateTp aujourdhui() {
        final Calendar calendar = new GregorianCalendar();
        final Date dateJour = new Date();
        calendar.setTime(dateJour);
        final int annee = calendar.get(1);
        final int mois = calendar.get(2) + 1;
        final int jour = calendar.get(5);
        final DateTp d = new DateTp(annee, mois, jour);
        return d;
    }
    
    public int annee() {
        return this.annee;
    }
    
    public int mois() {
        return this.mois;
    }
    
    public int jour() {
        return this.jour;
    }
    
    public String afficheDate() {
        final String date = String.valueOf(this.jour) + "-" + this.mois + "-" + this.annee;
        return date;
    }
    
    @Override
    public String toString() {
        final String date = String.valueOf(this.annee) + "-" + this.mois + "-" + this.jour;
        return date;
    }
    
    public long difference(final DateTp uneDate) {
        final long CONST_DURATION_OF_DAY = 86400000L;
        final Calendar calendar1 = new GregorianCalendar();
        calendar1.set(1, uneDate.annee());
        calendar1.set(2, uneDate.mois());
        calendar1.set(5, uneDate.jour());
        final Date date1 = calendar1.getTime();
        final Calendar calendar2 = new GregorianCalendar();
        calendar2.set(1, this.annee);
        calendar2.set(2, this.mois);
        calendar2.set(5, this.jour);
        final Date date2 = calendar2.getTime();
        final long diff = date2.getTime() - date1.getTime();
        final long numberOfDay = diff / CONST_DURATION_OF_DAY;
        return numberOfDay;
    }
}
