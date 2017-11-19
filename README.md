# spring-oauth2
This repository contains code sample to use Spring OAuth2 libraries.
The repository contains two projects, corresponding to two applications:
<ul>
<li>oauth2-authserver : the authorization server</li>
<li>oauth2-resourceserver : the resource server</li>
</ul>
<p>
To test the applications, launch both auhtorization server & resource server.
</p>
<p>
The authorization server will be bound to port 8080.<br>
The resource server will be bound to port 8081.<br>
</p>
<p>
<h4>Step 1. Get a token from the authorization server</h4>


```
 curl.exe sample-clientId:secret@localhost:8080/oauth/token -d grant_type=client_credentials
```

The authorization server will return you a token, which you will pass to
the resource server to grant access to the protected resource

<h4>Step 2. Pass the token to the resource server</h4>

Pass the token to the resource server using a HTTP Auhtorization header, as below (change the token value to the value returned by the authorization server):
```
curl -H "Authorization: Bearer 0bf98ea5-2f4b-4a57-82da-1f6ef0281fad" localhost:8081/secured
```

The resource server will then validate the token with the resource server, and grant you access to the URL.