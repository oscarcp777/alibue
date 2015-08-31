<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'book.label', default: 'Book')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>

    <div role="main" class="row">
        <div class="col-xs-12">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div class="form-horizontal">
            <f:display bean="book" />
            </div>
            <g:form resource="${this.book}" method="DELETE">
                <div class="clearfix form-actions">
                    <div class="col-md-offset-3 col-md-9">
                    <g:link class="btn btn-primary " action="edit" resource="${this.book}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="btn btn-primary " type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </div>
                </div>
            </g:form>
        </div>
        </div>
    </body>
</html>
