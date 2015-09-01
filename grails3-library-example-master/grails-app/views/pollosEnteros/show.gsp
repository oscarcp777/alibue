<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'pollosEnteros.label', default: 'PollosEnteros')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <g:link class="btn btn-info" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link>
                 <g:link class="btn btn-info" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-pollosEnteros" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div class="form-horizontal">
            <f:display bean="pollosEnteros" />
            </div>
            <g:form resource="${this.pollosEnteros}" method="DELETE">
                <div class="clearfix form-actions">
                    <div class="col-md-offset-3 col-md-9">
                    <g:link class="btn btn-primary" action="edit" resource="${this.pollosEnteros}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="btn btn-primary" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </div>
                </div>
            </g:form>
        </div>
    </body>
</html>
