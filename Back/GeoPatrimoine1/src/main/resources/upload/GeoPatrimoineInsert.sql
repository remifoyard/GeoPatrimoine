
insert into authentification (motDePasse, utilisateur) values('equipe4', 'Equipe_4');


insert into patrimoinehistorique 
	(
	adresse, codePostal, commune, description,
	geoTag, horaires, lienAudio, lienImage, nom,
	tarif, tarifMax, tarifMin, telephone
	)
values
	(
	'1 Place de la Comédie',
	'69001',
	'Lyon',
	'Le Grand Théâtre fut construit en 1756 par Jacques-Germain Soufflot (1713-1780 qui fit également à Paris le Panthéon, l’église Ste Geneviève, etc) et reconstruit de 1827 à 1831 par les architectes Chenavard et Pollet, il fut alors appelé Opéra.',
	'4.836610,45.767793',
	'Samedi',
	'opera.mp3',
	'opera_lyon.jpg',
	'Opéra de Lyon',
	'13', '13', '200',
	'0472004500'
	),
	
	(
	'place de Fourvière',
	'69005',
	'Lyon',
	'Cet édifice au style éclectique surplombe Lyon, "forteresse mariale" à l\'extérieur, ornée à l\'intérieur de mosaïques, vitraux et marbres. De l\'esplanade, la vue panoramique est imprenable. Visite insolite des toits incluse dans la Lyon City Card.',
	'4.822626,45.762293',
	'Ouvert tous les jours. Basilique et crypte : de 8h à 19h. Chapelle : de 7h à 19h. Esplanade : de 6h à 21h30.',
	'basilique_fourviere_lyon.mp3',
	'basilique_fourviere_lyon.jpg',
	'Basilique de Fourvière',
	'Gratuit', '0', '0',
	'0478251301'),
	
	(
	'Place Bellecour',
	'69002',
	'Lyon',
	'3ème plus grande place de France (après la Concorde à Paris et les Quinconces à Bordeaux), elle tire son nom de "Bella Curia" et renommée successivement place Louis-le-Grand, Place de la Fédération, place Bonaparte et enfin Place Bellecour en 1850.',
	'4.832316,45.757796',
	'24h/24 7j/7',
	'place_bellecour.mp3',
	'place_bellecour.jpg',
	'La Place Bellecour',
	'Gratuit', '0', '0',
	'0472776969'
	);