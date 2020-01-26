package ru.mail.dimaushenko.constants;

public class HtmlPatterns {

    public static final String HEAD_HTML = "<html><body>";
    public static final String END_HTML = "</body></html>";

    public static final String VIEW_ALL_USER_START = ""
            + "<html>\n"
            + "    <body>\n"
            + "        <h2>Hello World!</h2>\n"
            + "        <table border=\"1\">\n"
            + "            <tr>"
            + "                <td >id</td>\n"
            + "                <td>username</td>\n"
            + "                <td>password</td>\n"
            + "                <td>isActive</td>\n"
            + "                <td>age</td>\n"
            + "           </tr>";

    public static final String VIEW_ALL_USER_END = ""
            + "        </table>\n"
            + "    </body>\n"
            + "</html>";

    public static final String VIEW_ALL_USER_TABLE_PATTERN = ""
            + "<tr>\n"
            + "    <td ><ID></td>\n"
            + "    <td><USERNAME></td>\n"
            + "    <td><PASSWORD></td>\n"
            + "    <td><IS_ACTIVE></td>\n"
            + "    <td><AGE></td>\n"
            + "</tr>";

    public static final String USER_INSERT_ID = "<ID>";
    public static final String USER_INSERT_USERNAME = "<USERNAME>";
    public static final String USER_INSERT_PASSWORD = "<PASSWORD>";
    public static final String USER_INSERT_IS_ACTIVE = "<IS_ACTIVE>";
    public static final String USER_INSERT_AGE = "<AGE>";

    private HtmlPatterns() {
    }

}
