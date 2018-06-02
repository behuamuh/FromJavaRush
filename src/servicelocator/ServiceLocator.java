package servicelocator;


import servicelocator.contex.InitialContext;
import servicelocator.service.Service;

public class ServiceLocator {
    private static Cache cache;

    static {
        cache = new Cache();
    }

    /**
     * First check the service object available in cache
     * If service object not available in cache do the lookup using
     * JNDI initial context and get the service object. Add it to
     * the cache for future use.
     *
     * @param jndiName The name of service object in context
     * @return Object mapped to name in context
     */
    public static Service getService(String jndiName) {

        Service newService = cache.getService(jndiName);
        if (newService == null){
            newService = (Service) new InitialContext().lookup(jndiName);
            if (newService != null)
                cache.addService(newService);
        }
        return newService;
    }
}
