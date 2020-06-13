
package servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "WebServiceProveedor")
public class WebServiceProveedor {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello from WebServiceProveedor" + txt + " !";
    }
}
