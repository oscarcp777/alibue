<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'pollosTrozados.label', default: 'PollosTrozados')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>

<div class="nav" role="navigation">
    <ul>
        <li><g:link class="btn btn-info" action="index">Volver al listado</g:link></li>
    </ul>
</div>
<div role="main" class="row">
    <div class="col-xs-12">
        <h1><g:message code="default.create.label" args="[entityName]" /></h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <hr>
        <g:hasErrors bean="${this.pollosTrozados}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.pollosTrozados}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
        </g:hasErrors>
        <g:form action="save">
            <div class="form form-horizontal">
                <f:all bean="pollosTrozados"/>
            </div>
            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                    <g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </div>
            </div>
        </g:form>
    </div>
</div>
</body>
</html>
