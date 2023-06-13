<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<%@ include file="/WEB-INF/Menu.jsp" %>
<body>
<section style="background-color: #eee;">
  <div class="text-center container py-5">
    <h4 class="mt-4 mb-5"><strong>Utilisateurs</strong></h4>

	<c:forEach var = "i" begin="0" end="${ listeU.size() - 1 }" step="3">
    <div class="row">
      <div class="col-lg-4 col-md-12 mb-4">
        <div class="card">
          <div class="bg-image hover-zoom ripple ripple-surface ripple-surface-light"
            data-mdb-ripple-color="light">
            <img src="https://static.vecteezy.com/system/resources/previews/019/896/012/original/female-user-avatar-icon-in-flat-design-style-person-signs-illustration-png.png"
              class="w-100" />
              <div class="mask">
                <div class="d-flex justify-content-start align-items-end h-100">
                  <h5><span class="badge bg-primary ms-2">${ listeU.get(i).getListeRoles().get(0).nom }</span></h5>
                </div>
              </div>
              <div class="hover-overlay">
                <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
              </div>
          </div>
          <div class="card-body">
            <a href="" class="text-reset">
              <h5 class="card-title mb-3">${ listeU.get(i).login }</h5>
            </a>
            <a href="" class="text-reset">
              <p>${ listeU.get(i).getUtilisateurDetails().telephone }</p>
            </a>
            <h6 class="mb-3">${ listeU.get(i).getUtilisateurDetails().mail }</h6>
            
            <a href="modifierU?id=${ listeU.get(i).id }"><button type="button" class="btn btn-warning">Modifier</button></a>
            <a href="supprimerU?id=${ listeU.get(i).id }"><button type="button" class="btn btn-danger">Supprimer</button></a>
            
          </div>
        </div>
      </div>

		<c:if test="${ listeU.get(i + 1) != null }">
      <div class="col-lg-4 col-md-6 mb-4">
        <div class="card">
          <div class="bg-image hover-zoom ripple ripple-surface ripple-surface-light"
            data-mdb-ripple-color="light">
            <img src="https://static.vecteezy.com/system/resources/previews/019/896/012/original/female-user-avatar-icon-in-flat-design-style-person-signs-illustration-png.png"
              class="w-100" />
              <div class="mask">
                <div class="d-flex justify-content-start align-items-end h-100">
                  <h5><span class="badge bg-success ms-2">${ listeU.get(i + 1).getListeRoles().get(0).nom }</span></h5>
                </div>
              </div>
              <div class="hover-overlay">
                <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
              </div>
          </div>
          <div class="card-body">
            <a href="" class="text-reset">
              <h5 class="card-title mb-3">${ listeU.get(i + 1).login }</h5>
            </a>
            <a href="" class="text-reset">
              <p>${ listeU.get(i + 1).getUtilisateurDetails().telephone }</p>
            </a>
            <h6 class="mb-3">${ listeU.get(i + 1).getUtilisateurDetails().mail }</h6>
            <a href="modifierU?id=${ listeU.get(i + 1).id }"><button type="button" class="btn btn-warning">Modifier</button></a>
            <a href="supprimerU?id=${ listeU.get(i + 1).id }"><button type="button" class="btn btn-danger">Supprimer</button></a>
          </div>
        </div>
      </div>
		</c:if>
		
		<c:if test="${ listeU.get(i + 2) != null }">
      <div class="col-lg-4 col-md-6 mb-4">
        <div class="card">
          <div class="bg-image hover-zoom ripple" data-mdb-ripple-color="light">
            <img src="https://static.vecteezy.com/system/resources/previews/019/896/012/original/female-user-avatar-icon-in-flat-design-style-person-signs-illustration-png.png"
              class="w-100" />
              <div class="mask">
                <div class="d-flex justify-content-start align-items-end h-100">
                  <h5><span class="badge bg-danger ms-2">${ listeU.get(i + 2).getListeRoles().get(0).nom }</span></h5>
                </div>
              </div>
              <div class="hover-overlay">
                <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
              </div>
          </div>
          <div class="card-body">
            <a href="" class="text-reset">
              <h5 class="card-title mb-3">${ listeU.get(i + 2).login }</h5>
            </a>
            <a href="" class="text-reset">
              <p>${ listeU.get(i + 2).getUtilisateurDetails().telephone }</p>
            </a>
            <h6 class="mb-3">${ listeU.get(i + 2).getUtilisateurDetails().mail }</h6>
            <a href="modifierU?id=${ listeU.get(i + 2).id }"><button type="button" class="btn btn-warning">Modifier</button></a>
            <a href="supprimerU?id=${ listeU.get(i + 2).id }"><button type="button" class="btn btn-danger">Supprimer</button></a>
          </div>
        </div>
      </div>   
    	</c:if>
    </c:forEach>
    </div>
 
</section>

</body>
</html>