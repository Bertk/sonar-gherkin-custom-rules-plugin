Sample plugin that defines SonarQube custom rules for Cucumber Gherkin feature files
====================================================================================

## Description
The [SonarQube Gherkin plugin](https://github.com/racodond/sonar-gherkin-plugin) can be enhanced by writing custom rules through a plugin using SonarQube Gherkin API. The [Gherkin sample plugin](https://github.com/racodond/sonar-gherkin-custom-rules-plugin) was used as template for this plugin.
This plugin adds one additional rule "allowed-composite-tag".

  <table class="tg">
   <tr>
    <th class="tg-yw4l">tag</th>
    <th class="tg-yw4l">regular expression</th>
   </tr>
   <tr>
    <td class="tg-yw4l">tc</td>
    <td class="tg-yw4l">\d+</td>
   </tr>
   <tr>
    <td class="tg-yw4l">us</td>
    <td class="tg-yw4l">\d+</td>
   </tr>
   <tr>
    <td class="tg-yw4l">wi</td>
    <td class="tg-yw4l">\d+</td>
   </tr>
   <tr>
    <td class="tg-yw4l">bug</td>
    <td class="tg-yw4l">\d+</td>
   </tr>
   <tr>
    <td class="tg-yw4l">uid</td>
    <td class="tg-yw4l">[a-zA-Z''-'\s]{1,40}</td>
   </tr>
   <tr>
    <td class="tg-yw4l">owner</td>
    <td class="tg-yw4l">[a-zA-Z''-'_\\s]{1,40}</td>
   </tr>
   <tr>
    <td class="tg-yw4l">tfs</td>
    <td class="tg-yw4l">(ht|f)tp(s?)\:\/\/[0-9a-zA-Z]([-.\w]*[0-9a-zA-Z])*(:(0-9)*)*(\/?)([a-zA-Z0-9\-\.\?\,\'\/\\\+&amp;%\$#_]*)?</td>
   </tr>
  </table>

Examples of coding rule implementation and testing can be found in the Gherkin plugin [`gherkin-checks` module](https://github.com/racodond/sonar-gherkin-plugin/tree/master/gherkin-checks/src/main/java/org/sonar/gherkin/checks).
