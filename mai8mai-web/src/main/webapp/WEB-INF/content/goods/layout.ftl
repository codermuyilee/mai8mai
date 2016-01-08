<#macro defaultHeader>
<#include "header.ftl">
</#macro>

<#macro defaultFooter>
    <#include "footer.ftl">
</#macro>

<#macro layout header=defaultHeader footer=defaultFooter>
    <@header />
    <#nested>
    <@footer />
</#macro>