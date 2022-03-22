sealed class Failure {
    /*Network Error*/
    class NetworkConnection(var additionalData: Any? = null) : Failure()

    /*Exception*/
    class Exception(var additionalData: Any? = null) : Failure()

    /**
     * Although the HTTP standard specifies "unauthorized",
     * semantically this response means "unauthenticated".
     * That is, the client must authenticate itself to get the requested response.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class UnauthorizedError(val httpCode: Int = 401, val additionalData: Any? = null) : Failure()

    /**
     * The user has sent too many requests in a given amount of time ("rate limiting").
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class TooManyRequest(val httpCode: Int = 429, val additionalData: Any? = null) : Failure()

    /**
     * The server cannot or will not process the request due to something that is perceived to be a client error
     * (e.g., malformed request syntax, invalid request message framing, or deceptive request routing).
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class BadRequest(val httpCode: Int = 400, val additionalData: Any? = null) : Failure()

    /**
     * This response code is reserved for future use.
     * The initial aim for creating this code was using it for digital payment systems,
     * however this status code is used very rarely and no standard convention exists.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class PaymentRequired(val httpCode: Int = 402, val additionalData: Any? = null) : Failure()

    /**
     * The client does not have access rights to the content; that is, it is unauthorized,
     * so the server is refusing to give the requested resource.
     * Unlike 401 Unauthorized, the client's identity is known to the server.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class Forbidden(val httpCode: Int = 403, val additionalData: Any? = null) : Failure()

    /**
     * The server can not find the requested resource. In the browser, this means the URL is not recognized.
     * In an API, this can also mean that the endpoint is valid but the resource itself does not exist.
     * Servers may also send this response instead of 403 Forbidden to hide the existence of a resource from an unauthorized client.
     * This response code is probably the most well known due to its frequent occurrence on the web.
     */
    class NotFound(val httpCode: Int = 404, val additionalData: Any? = null) : Failure()

    /**
     * The request method is known by the server but is not supported by the target resource.
     * For example, an API may not allow calling DELETE to remove a resource.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class MethodNotAllowed(val httpCode: Int = 405, val additionalData: Any? = null) : Failure()

    /**
     * This response is sent when the web server, after performing server-driven content negotiation,
     * doesn't find any content that conforms to the criteria given by the user agent.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class NotAcceptable(val httpCode: Int = 406, val additionalData: Any? = null) : Failure()

    /**
     * This is similar to 401 Unauthorized but authentication is needed to be done by a proxy.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class ProxyAuthenticationRequired(val httpCode: Int = 407, val additionalData: Any? = null) : Failure()

    /**
     * This response is sent on an idle connection by some servers, even without any previous request by the client.
     * It means that the server would like to shut down this unused connection.
     * This response is used much more since some browsers, like Chrome, Firefox 27+, or IE9, use HTTP pre-connection mechanisms to speed up surfing.
     * Also note that some servers merely shut down the connection without sending this message.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class RequestTimeout(val httpCode: Int = 408, val additionalData: Any? = null) : Failure()

    /**
     * This response is sent when a request conflicts with the current state of the server.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class Conflict(val httpCode: Int = 409, val additionalData: Any? = null) : Failure()

    /**
     * This response is sent when the requested content has been permanently deleted from server, with no forwarding address.
     * Clients are expected to remove their caches and links to the resource.
     * The HTTP specification intends this status code to be used for "limited-time, promotional services".
     * APIs should not feel compelled to indicate resources that have been deleted with this status code.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class Gone(val httpCode: Int = 410, val additionalData: Any? = null) : Failure()

    /**
     * Server rejected the request because the Content-Length header field is not defined and the server requires it.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class LengthRequired(val httpCode: Int = 411, val additionalData: Any? = null) : Failure()

    /**
     * The client has indicated preconditions in its headers which the server does not meet.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class PreconditionFailed(val httpCode: Int = 412, val additionalData: Any? = null) : Failure()

    /**
     * Request entity is larger than limits defined by server.
     * The server might close the connection or return an Retry-After header field.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class PayloadTooLarge(val httpCode: Int = 413, val additionalData: Any? = null) : Failure()

    /**
     * The URI requested by the client is longer than the server is willing to interpret.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class URITooLong(val httpCode: Int = 414, val additionalData: Any? = null) : Failure()

    /**
     * The media format of the requested data is not supported by the server, so the server is rejecting the request.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class UnsupportedMediaType(val httpCode: Int = 415, val additionalData: Any? = null) : Failure()

    /**
     * The range specified by the Range header field in the request cannot be fulfilled.
     * It's possible that the range is outside the size of the target URI's data.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class RangeNotSatisfied(val httpCode: Int = 416, val additionalData: Any? = null) : Failure()

    /**
     * This response code means the expectation indicated by the Expect request header field cannot be met by the server.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class ExpectationFailed(val httpCode: Int = 417, val additionalData: Any? = null) : Failure()

    /**
     * The request was directed at a server that is not able to produce a response.
     * This can be sent by a server that is not configured to produce responses
     * for the combination of scheme and authority that are included in the request URI.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class MisdirectedRequest(val httpCode: Int = 421, val additionalData: Any? = null) : Failure()

    /**
     * The request was well-formed but was unable to be followed due to semantic errors.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class UnprocessableEntity(val httpCode: Int = 422, val additionalData: Any? = null) : Failure()

    /**
     * The resource that is being accessed is locked.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class Locked(val httpCode: Int = 423, val additionalData: Any? = null) : Failure()

    /**
     * The request failed due to failure of a previous request.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class FailedDependency(val httpCode: Int = 424, val additionalData: Any? = null) : Failure()

    /**
     * Indicates that the server is unwilling to risk processing a request that might be replayed.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class TooEarly(val httpCode: Int = 425, val additionalData: Any? = null) : Failure()

    /**
     * The server refuses to perform the request using the current protocol but might be willing
     * to do so after the client upgrades to a different protocol.
     * The server sends an Upgrade header in a 426 response to indicate the required protocol(s).
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class UpgradeRequired(val httpCode: Int = 426, val additionalData: Any? = null) : Failure()

    /**
     * The origin server requires the request to be conditional.
     * This response is intended to prevent the 'lost update' problem, where a client GETs a resource's state,
     * modifies it and PUTs it back to the server,
     * when meanwhile a third party has modified the state on the server, leading to a conflict.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class PreconditionRequired(val httpCode: Int = 428, val additionalData: Any? = null) : Failure()

    /**
     * The server is unwilling to process the request because its header fields are too large.
     * The request may be resubmitted after reducing the size of the request header fields.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class RequestHeaderFieldsTooLarge(val httpCode: Int = 431, val additionalData: Any? = null) : Failure()


    /**
     * The user agent requested a resource that cannot legally be provided, such as a web page censored by a government.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class UnavailableForLegalReason(val httpCode: Int = 451, val additionalData: Any? = null) : Failure()

    /**
     * The server has encountered a situation it does not know how to handle.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class CanNotConnectToTheServer(val httpCode: Int = 500, val additionalData: Any? = null) : Failure()

    /**
     * The request method is not supported by the server and cannot be handled.
     * The only methods that servers are required to support (and therefore that must not return this code) are GET and HEAD.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class NotImplemented(val httpCode: Int = 501, val additionalData: Any? = null) : Failure()


    /**
     * This error response means that the server, while working as a gateway
     * to get a response needed to handle the request, got an invalid response.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class BadGateway(val httpCode: Int = 502, val additionalData: Any? = null) : Failure()

    /**
     * The server is not ready to handle the request.
     * Common causes are a server that is down for maintenance or that is overloaded.
     * Note that together with this response, a user-friendly page explaining the problem should be sent.
     * This response should be used for temporary conditions and the Retry-After HTTP header should,
     * if possible, contain the estimated time before the recovery of the service.
     * The webmaster must also take care about the caching-related headers that are sent along with this response,
     * as these temporary condition responses should usually not be cached.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class ServiceUnavailable(val httpCode: Int = 503, val additionalData: Any? = null) : Failure()

    /**
     * This error response is given when the server is acting as a gateway and cannot get a response in time.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class GatewayTimeout(val httpCode: Int = 504, val additionalData: Any? = null) : Failure()

    /**
     * The HTTP version used in the request is not supported by the server.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class HTTPVersionNotSupported(val httpCode: Int = 505, val additionalData: Any? = null) : Failure()

    /**
     * The server has an internal configuration error: the chosen valiant resource is configured to engage in transparent content negotiation itself, and is therefore not a proper end point in the negotiation process.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class VariantAlsoNegotiates(val httpCode: Int = 506, val additionalData: Any? = null) : Failure()

    /**
     * The method could not be performed on the resource because the server is unable to store the representation needed to successfully complete the request.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class InsufficientStorage(val httpCode: Int = 507, val additionalData: Any? = null) : Failure()

    /**
     * The server detected an infinite loop while processing the request.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class LoopDetected(val httpCode: Int = 508, val additionalData: Any? = null) : Failure()

    /**
     * Further extensions to the request are required for the server to fulfill it.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class NotExtended(val httpCode: Int = 510, val additionalData: Any? = null) : Failure()

    /**
     * Indicates that the client needs to authenticate to gain network access.
     *
     * @param httpCode HTTP Code.
     * @param additionalData If you want to provide additional data to the client.
     */
    class NetworkAuthenticationRequired(val httpCode: Int = 511, val additionalData: Any? = null) : Failure()
}
