package com.portier.oauth.examples;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.oauth2.TokenResult;

import com.portier.oauth.AuthContextImpl;
import com.portier.oauth.OAuthService;
import com.portier.oauth.OAuthServiceBuilder;
import com.portier.oauth.api.AuthenticationCompletionHandler;
import com.portier.oauth.api.AuthenticationContext;
import com.portier.oauth.providers.google.Google;

@Path("oauthgoogle")
public class OAuthResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTokens(){
		try {
			final OAuthService oauthsvc =
        	        new OAuthServiceBuilder().provider(Google.class).
        	        build();
			
		    final AuthenticationContext ctx = new AuthContextImpl( 
		    		new AuthenticationCompletionHandler() {
				
				@Override
				public Response handleError(Exception e) {
					e.printStackTrace();
					return null;
				}
				
				@Override
				public Response handleCompletion(AuthenticationContext ctx) {
					 TokenResult result = ctx.getTokenResult();
				      
				      final AccessTokenData test = new AccessTokenData();
				      test.setAccessToken(result.getAccessToken());
				      test.setRefreshToken(result.getRefreshToken());
				      
				      return Response.ok(test,MediaType.APPLICATION_JSON).build();
				}
			});
		    	
		    return oauthsvc.startAuthentication(ctx);
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.noContent().build();
	}

}
