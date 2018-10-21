package gouglhupf.gpx;

import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.format.ResolverStyle;

import java.util.regex.Pattern;

import static org.threeten.bp.ZoneOffset.UTC;
import static org.threeten.bp.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

/**
 * Enumeration of the valid date time formats.
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @version 1.0
 * @since 1.0
 */
enum ZonedDateTimeFormat {

    // http://books.xmlschemata.org/relaxng/ch19-77049.html

    ISO_DATE_TIME_UTC(
            new DateTimeFormatterBuilder()
                    .append(ISO_LOCAL_DATE_TIME)
                    .optionalStart()
                    .appendOffsetId()
                    .toFormatter()
                    .withResolverStyle(ResolverStyle.LENIENT)
                    .withZone(UTC),
            "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d{1,9})*+Z*+$"
    ),

    ISO_DATE_TIME_OFFSET(
            new DateTimeFormatterBuilder()
                    .append(ISO_LOCAL_DATE_TIME)
                    .optionalStart()
                    .appendOffsetId()
                    .toFormatter(),
            "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d{1,9})*+([+-]\\d{2}:\\d{2})"
    );

    // Default formatter used for formatting time strings.
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ISO_DATE_TIME.withZone(UTC);

    private final DateTimeFormatter _formatter;
    private final Pattern[] _patterns;

    ZonedDateTimeFormat(final DateTimeFormatter formatter, final String... patterns) {
        if (formatter == null)
            throw new NullPointerException();

        _formatter = formatter;
        _patterns = new Pattern[patterns.length];
        for (int i = 0; i < patterns.length; i++) {
            _patterns[i] = Pattern.compile(patterns[i]);
        }
    }

    private boolean matches(final String time) {
        for (Pattern pattern : _patterns) {
            if (pattern.matcher(time).matches())
                return true;
        }

        return false;
    }

    /**
     * Parses the given time string with the current formatter.
     *
     * @param time the time string to pare
     * @return the parsed zoned date time
     * @throws DateTimeParseException if the text cannot be parsed
     */
    public ZonedDateTime formatParse(final String time) {
        return time != null ? ZonedDateTime.parse(time, _formatter) : null;
    }

    /**
     * Return the default format of the given {@code ZonedDateTime}.
     *
     * @param time the {@code ZonedDateTime} to format
     * @return the time string of the given zoned date time
     */
    public static String format(final ZonedDateTime time) {
        return time != null ? FORMATTER.format(time) : null;
    }

    /**
     * Parses the given object to a zoned data time object.
     *
     * @param time the string to parse
     * @return the parsed object
     */
    public static ZonedDateTime parse(final String time) {
        if (time == null)
            return null;

        ZonedDateTimeFormat tf = findFormat(time);

        if (tf == null)
            throw new IllegalArgumentException(
                    String.format("Can't parse time: %s'", time));

        return tf.formatParse(time);
    }

    /**
     * Finds the formatter which fits the given {@code time} string.
     *
     * @param time the time string
     * @return the formatter which fits to the given {@code time} string, or
     * {@code Optional.empty()} of no formatter is found
     */
    static ZonedDateTimeFormat findFormat(final String time) {
        for (ZonedDateTimeFormat tf : values()) {
            if (tf.matches(time))
                return tf;
        }

        return null;
    }

}
