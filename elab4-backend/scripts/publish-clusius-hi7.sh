eb=http://rest.elaborate.huygens.knaw.nl
rootcode=`curl --silent --show-error --data "username=root&password=toor" $eb/sessions/login/|jq -r ".token"`; echo $rootcode
project_id=17
curl -i -H "Authorization: SimpleAuth $rootcode" -H "Content-Type: application/json" -X PUT -d '{"publishableTextLayers": "[\"Transcription\",\"Translation\"]", "publishableAnnotationTypeIds":"[94,1,31,93,32]", "publishableProjectEntryMetadataFields":"[\"Sender\",\"Place of creation\",\"Recipient\",\"Place of receipt\",\"Date\",\"Language\",\"Signature\",\"Source of transcription/edition\",\"Source of translation\",\"Notes\",\"facsimile\"]", "facetableProjectEntryMetadataFields":"[\"Sender\",\"Place of creation\",\"Recipient\",\"Place of receipt\",\"Date\",\"Language\",\"Signature\",\"Source of transcription/edition\"]"}' $eb/projects/$project_id/settings
curl -s -H "Authorization: SimpleAuth $rootcode" $eb/projects/$project_id/settings|jq "."
curl -i -H "Authorization: SimpleAuth $rootcode" -H "Content-Type: application/json" -X POST $eb/projects/$project_id/draft
