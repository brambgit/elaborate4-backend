<#ftl encoding="UTF-8" strip_whitespace=true>
<#macro dc field value>
  <#if value?has_content>
  <dc:${field}>${value}</dc:${field}>
  </#if>
</#macro>
<oai_dc:dc
  xmlns:oai_dc="http://www.openarchives.org/OAI/2.0/oai_dc/"
  xmlns:dc="http://purl.org/dc/elements/1.1/"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.openarchives.org/OAI/2.0/oai_dc/ http://www.openarchives.org/OAI/2.0/oai_dc.xsd">
  <@dc field="contributor" value=contributor/>  
  <@dc field="coverage" value=coverage/>  
  <@dc field="creator" value=creator/>  
  <@dc field="date" value=date/>  
  <@dc field="description" value=description/>  
  <@dc field="format" value=format/>  
  <@dc field="identifier" value=identifier/>  
  <@dc field="language" value=language/>  
  <@dc field="publisher" value=publisher/>  
  <@dc field="relation" value=relation/>  
  <@dc field="rights" value=rights/>  
  <@dc field="source" value=source/>  
  <@dc field="subject" value=subject/>  
  <@dc field="title" value=title/>  
  <@dc field="type" value=type/>  
</oai_dc:dc>
