package br.com.cod2d.api.config.base.error;

public class ErrorDTOFactory {
    public ErrorDTOFactory() {
    }

    public static ErrorDTO getMissingParameter(final String info, final String field) {
        return new ErrorDTO("Missing " + info + " parameter " + field,
                "Field " + field + " is required and can not be empty",
                ErrorCodeEnum.MISSING_PARAMETERS.getCode());
    }

    public static ErrorDTO getUnknownParameter(final String info, final String field) {
        return new ErrorDTO("Unknown " + info + " parameter " + field,
                "Field " + field + " is unknown", ErrorCodeEnum.UNKNOWN_PARAMETERS.getCode());
    }

    public static ErrorDTO getMissingRequestBody() {
        return new ErrorDTO("Missing request body",
                "Missing request body", ErrorCodeEnum.MISSING_REQUEST_BODY.getCode());
    }

    public static ErrorDTO getNotFound(final String name) {
        return new ErrorDTO(name + " not found ",
                " You attempted to get a " + name + ", but did not find any",
                ErrorCodeEnum.NOT_FOUND.getCode());
    }

    public static ErrorDTO getConflict(final String name) {
        return new ErrorDTO(name + " ,conflict ",
                " Attempted to perform an action on the server " + name + ",conflict",
                ErrorCodeEnum.CONFLICT.getCode());
    }

    public static ErrorDTO getAlreadyExists(final String name) {
        return new ErrorDTO(name + " already exists ",
                " You attempted to create a " + name + ", but already exists",
                ErrorCodeEnum.ALREADY_EXISTS.getCode());
    }

    public static ErrorDTO getUnsupportedOperation(
            final String description, final String paramName, final String paramValue) {
        return new ErrorDTO("Unsupported Operation",
                "You attempted to execute with " + description +
                        " parameter " + paramName + "=" + paramValue + ", " +
                        "but is not supported yet", ErrorCodeEnum.UNSUPPORT_OPERATION.getCode());
    }

    public static ErrorDTO getIvalidFieldLesser(
            final String info, final String field, final Integer lesserValue) {
        return new ErrorDTO("Invalid " + info + " parameter " + field
                + ". it must be filled with a value lesser than " + lesserValue,
                "Invalid field " + field + " - it must be filled with a value lesser than "
                        + lesserValue, ErrorCodeEnum.INVALID_FIELD_LESSER.getCode());
    }

    public static ErrorDTO getIvalidFieldGreater(
            final String info, final String field, final Integer greaterValue) {
        return new ErrorDTO("Invalid " + info + " parameter " + field
                + ". it must be filled with a value greater than " + greaterValue,
                "Invalid field " + field + " - it must be filled with a value greater than "
                        + greaterValue, ErrorCodeEnum.INVALID_FIELD_GREATER.getCode());
    }

    public static ErrorDTO getGreaterOrEqualsMessage(final String info, final String field,
                                                     final Integer greaterValue) {
        return new ErrorDTO("Invalid " + info + " parameter " + field +
                ". it must be filled with a value greater than or equals to " + greaterValue,
                "Invalid field " + field + " - it must be filled with a value greater than or equals to "
                        + greaterValue, ErrorCodeEnum.INVALID_FIELD_GREATER.getCode());
    }

    public static ErrorDTO getInternalServerError(final String message) {
        return new ErrorDTO(message, "Sorry, something went wrong",
                ErrorCodeEnum.INTERNAL_SERVER_ERROR.getCode());
    }

    public static ErrorDTO getMissingParameters(final String message) {
        return new ErrorDTO(message, "Invalid or missing parameters",
                ErrorCodeEnum.MISSING_PARAMETERS.getCode());
    }

    public static ErrorDTO getConnectionTargetTimeout() {
        return new ErrorDTO("Connection target timeout",
                "Connection time out between proxy and target",
                ErrorCodeEnum.CONNECTION_TARGET_TIMEOUT.getCode());
    }

    public static ErrorDTO getMalformedRequestBody(final String message) {
        return new ErrorDTO(message, "Malformed request body",
                ErrorCodeEnum.MALFORMED_REQUEST_BODY.getCode());
    }

    public static ErrorDTO getUnAuthorized() {
        return new ErrorDTO("Unauthorized - make sure the header parameter Authorization is valid",
                "You are not authorized to perform this operation",
                ErrorCodeEnum.UNAUTHORIZED.getCode());
    }

    public static ErrorDTO getInvalidDeliveryMethod(final String message) {
        return new ErrorDTO("Invalid delivery method. " + message +
                " is not available for this order", "Invalid delivery method. "
                + message + " is not available for this order", ErrorCodeEnum.INVALID_DELIVERY_METHOD.getCode());
    }
}
