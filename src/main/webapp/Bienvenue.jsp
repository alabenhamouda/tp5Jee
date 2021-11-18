<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Id User: ${user.idUser}</p>
	<p>Login: ${user.login}</p>
	<p>Pass: ${user.pass}</p>
	<p>Email: ${user.email}</p>
	<p>Ville: ${user.ville}</p>
	<a href="LogoutServlet"><button>Logout</button></a>
	<a href="ServletAjouter"><button>Ajouter Utilisateur</button></a>
	<a href="ServletListe"><button>Lister tous les  utilisateurs</button></a>
	<a href="ServletSupprimer"><button>Supprimer utilisateur</button></a>
	<a href="ServletModifier"><button>Modifier utilisateur</button></a>
</body>
</html>