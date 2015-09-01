<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'pollosTrozados.label', default: 'PollosTrozados')}" />
    <title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>
<body>
<div class="nav" role="navigation">
    <ul>
        <li><g:link class="btn btn-info" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link>
            <g:link class="btn btn-info" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="edit-pollosTrozados" class="content scaffold-edit" role="main">
    <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.pollosTrozados}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.pollosTrozados}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form resource="${this.pollosTrozados}" method="PUT">
        <g:hiddenField name="version" value="${this.pollosTrozados?.version}" />
        <div class="form form-horizontal">
            <f:all bean="pollosTrozados"/>
        </div>
        <div class="clearfix form-actions">
            <div class="col-md-offset-3 col-md-9">
            <input class="btn btn-primary" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                 </div>
    </g:form>
</div>
</body>
</html>
