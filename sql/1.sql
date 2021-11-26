PGDMP                     
    y            uchet_tekhniki    12.3    12.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16393    uchet_tekhniki    DATABASE     �   CREATE DATABASE uchet_tekhniki WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE uchet_tekhniki;
                postgres    false            �          0    77226    accounts 
   TABLE DATA           �   COPY public.accounts (id, email, telephone, password, last_name, first_name, middle_names, confirmation, confirmation_code, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    204   �       �          0    77363    spr_counterparty 
   TABLE DATA           �   COPY public.spr_counterparty (id, name, inn, telephone, email, contact, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    218   �       �          0    77242    spr_organization 
   TABLE DATA           k   COPY public.spr_organization (id, name, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    206   W       �          0    77395    doc_income_main 
   TABLE DATA           �   COPY public.doc_income_main (id, executed, data_executed, number_doc, data_doc, sum_con, number_con, data_con, counterparty_id, organization_id, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    222   t       �          0    77305    spr_device_type 
   TABLE DATA           q   COPY public.spr_device_type (id, name, level, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    212   (        �          0    77322    spr_firm 
   TABLE DATA           j   COPY public.spr_firm (id, name, level, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    214   �%       �          0    77339 	   spr_model 
   TABLE DATA           }   COPY public.spr_model (id, name, firm_id, device_type_id, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    216   �(       �          0    77419    doc_income_sub 
   TABLE DATA           �   COPY public.doc_income_sub (id, model_id, count, parent_id, sum, main_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    224   �4       �          0    77214    flyway_schema_history 
   TABLE DATA           �   COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
    public          postgres    false    202   F9       �          0    77379    spr_budget_account 
   TABLE DATA           s   COPY public.spr_budget_account (id, code, name, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    220   �9       �          0    77258    spr_location 
   TABLE DATA           u   COPY public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    208   �:       �          0    77279 	   spr_users 
   TABLE DATA           �   COPY public.spr_users (id, email, telephone, last_name, first_name, middle_names, location_id, organization_id, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    210   �<       �          0    77445    registry 
   TABLE DATA           �   COPY public.registry (id, model_id, inv_number, location_id, user_id, budget_account_id, parent_id, global_id, created_at, update_at) FROM stdin;
    public          postgres    false    226   �D       �          0    77485    registry_history 
   TABLE DATA           u   COPY public.registry_history (id, global_id, registry_id, type_record, old_value, new_value, created_at) FROM stdin;
    public          postgres    false    228   KR       �           0    0    accounts_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.accounts_id_seq', 9, true);
          public          postgres    false    203            �           0    0    doc_income_main_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.doc_income_main_id_seq', 8, true);
          public          postgres    false    221            �           0    0    doc_income_sub_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.doc_income_sub_id_seq', 258, true);
          public          postgres    false    223            �           0    0    registry_history_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.registry_history_id_seq', 1118, true);
          public          postgres    false    227            �           0    0    registry_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.registry_id_seq', 509, true);
          public          postgres    false    225            �           0    0    spr_budget_account_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.spr_budget_account_id_seq', 4, true);
          public          postgres    false    219            �           0    0    spr_counterparty_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.spr_counterparty_id_seq', 1, true);
          public          postgres    false    217            �           0    0    spr_device_type_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.spr_device_type_id_seq', 58, true);
          public          postgres    false    211            �           0    0    spr_firm_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.spr_firm_id_seq', 33, true);
          public          postgres    false    213            �           0    0    spr_location_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.spr_location_id_seq', 23, true);
          public          postgres    false    207            �           0    0    spr_model_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.spr_model_id_seq', 115, true);
          public          postgres    false    215            �           0    0    spr_organization_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.spr_organization_id_seq', 1, false);
          public          postgres    false    205            �           0    0    spr_users_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.spr_users_id_seq', 1, false);
          public          postgres    false    209            �   �   x�}�MJ1@יS���7���R�D�?((�$��N��2�]	^åGЭgHo��݃��$�6o��7���wݺ	�'�9���������v@q�{�s9^�t7�2����x�����<`����d�{��J��y�8���U~�w�q,��Bj���	Lh-x�^g�k5�&� Ǚ�%#T�-W�M�zIe�@�ꉠ&�P0��'R�h�����Hn      �   c   x�}̻�0 �:���l'�v�`�4|�D��@��H�;�(��?�	Q<k����4ϰ%VȻ$��К���q���4�D��Y�D�/���c|�@�      �      x������ � �      �   �   x����� �3L�@~`l3D'ȥi��_M�C�8F�/����>��0��?@8�`��t/�ɤ�L��J}�ޝ��g�IvCr[�A���D���JRE��Q�$���&i����fE1�SU��E�l$;��B�{$��U�g&c�SUjc��Lni�1�/1X�      �   y  x��X�n\E]����Ѵ���Kb	<$"Xeg)���9�B�$
	��mf{<�B�?�~\�}t#Y����U]u���(?΋<ϧ���Q���ͽ*T�F�ϋ�^��>�sw���Zj5V�+%k�k�D���X�n|2���G��:ɇ����lF�X���/'�N>���c��Gcс=R>��<��w�|
T�G�F�)�,�m�� �A#�G�;pa�Z���=}��j� *�!OG��g.��_М��k���>�x@�j����6��@�bc���ɳ4���f��l�g8��`6��eQ�(y�`�_hܡ�@m@t�=��S�`@��
�-��	���E� U����g�9"3�.f
�	��i�"�_4��8r�����Sl]��E�'/��A���yLMm�4���4;̓!Q�BZ�g����Z�&��{t�!�Z��Ja�����K&����x����#Ɋs©�L,AL��G�d؏1t��y��F���*
��w�1�g�"9.^
}^��V� 6P�����>�6k�5��Q(���s�Ŀ�5��ya���s�m��'�^��e���F(��+ <-B��
gĤه!�'!m����(�Ħ�E蠧gЧ5^|б�6Ć5��vZ5_�t��C]}S��ɤU�ΛP��J�7`���+�ĲiWK-�R�v���i(�p�Y��k4
I�����(T�p��*��S��:������Q��B�$}���ӆ�B%eۆ�X��
d��B��sm�)��~?�1�j�ly}N
�t���mCL�h��_}~���a_�$�
Rv�ӆx]���,|��nhB��'s��x��_Z3���G�/���$a�J��xm�y���s�:(���:j�G��� }�jCZ��ČE���vO�o ���v�S�
�2`O��q�1����aԀnN��� *"��қ��w�S��E�s�E����g��*ݩ�6�|��>�$)�Xa�����n��9%Bt.,q�b����>�a�N(�9�˘D4Quu�1#��ʸ)���Hb-��'}��!6����3.��	�RL����S�D
8��m��.)O�k���A�ZǴėK��@��Wo�5B���?.!6��- ��.kg�L�%羄�0T�����]`���ZJ|��dm!lضv�1��7]����=iC���7u�ٙ>���н����F����J��ѯ�vW f�g]ͥYEM�b�������9�w~����v���I�w�ۼh�z�Pm����W n��b+9���V��|����- �q=��d�7�c���8Zk�����2��r�2�ZUJ7�����%;�Q�ԧ��qC�b�|J���?�V�$��an����G�-      �   �  x����J�@��g���aΙ�����lQJ/��q�7)�][o���]�OP��ϐ�Qg3S#X���~���/y;'�7�yv��2�1��,���Z�L����ɾ�t八w��(�E�;� '�b�.�v��$]��;$�t>�� �:�
˵�1|H��gW��bPj����P�r2����˯�R�0��K�!��T���6g�C�N�t����q#�wG-�{�.j��Lj���[7����(�{<]�:�˼JE�XC�В�����D��ų}|�Z0rx+��*Q!�d��U9�C��Z���`D2��u-����r՛a�_oWV��E�� 9��N� y���5E{N"�!A(ɛ��b�\Ǎ*K��SvQp*�n�<l�X~�� �{��(5�ge���"����6��v�������MU^]C�ƐJ?���C�Ғ�`�|�߂h{� �P�2F��i:;R���/\�
JI�o�O_��1�tV�3�z,�%�����Y�.�%��޻cT�q?��tQHS���q��O�/������(�4����˶��ۆgԏ�P�3���W��Vyvq3���m�N�GB�/��'W/����O��	��/m��i~4��6�ͯ�ws��\ܬ����������}�C����_���	Ӕi��%�G!ɑ+W٦��OT�4�(�hb($rr0��j�<�=@����1
5�j���h4��c      �   X  x��[]o�}����Ļ��;�|�HYv$*��V\ /�D��-ɠ�����EZ��CݢE� �8N���/����-.��j�@�,{�ٙ;�ޙ��a�Iy���;'#�u6w����D avh���#���8��X�#E<��e)�-�[LƎ)��x�<�d�Q��tc	7dNeZ���h��8%qV�	�Z\�%D,���ʸ��c��@�B1kJ��K����+̆��kq��u\�2e���;��Y�&��pS �
�9��Y���(�w�E����
)��Hy(#t���m��i�����~�^�o�_�o����	ؚ*0*A��2���Ƹ ��Ag���S��D;�ӣ���C����ķ���eP���$�H'm�KD��)�%m��R(P
r�~�!��lG�	qD�
d|��1�N���Z�)��dxF;;�0ۋ��vt�M��_uȡ%Ul��ږA�\����h0�Pl7y@p�E���1WD��P�Ud%[{��ڻ'�b'ި���&V�I?h?f����<O�!H����n=�� U�L$Z���vJF=&�pp~t>_P��4bV&���eP`�d_2�N�N=��e]X�(���@�0�.�c��p���QMZ�[�IpЅ|��2Z��9������5�V<��nyr�@͗��ӊ��ĬṖy(�
�9z>�s��p�l<:ҞU��y}%J�N�U�
J���HjG�����Z�hV:f`=NI���Y���Jq�M��z���㫥��
�jN��cMX1	�y�~]��&�߰,�.�a���ӗ����~E��I�L���H_���k���e��
BI��^f��O/�D��2};�]z��
v���ᙇc�@�2(��7�����Zt��'�H]-�&->��W�]̘Ҭ0*y(�u�J���_8�Y�M�Ι2(���H�#���Y�1S
=���z��	��N��5�����6[U��!6�k�B�
z��zo���Q�5�
zT=�n��eZ��`t!��@Т+h��Z�}���:y(�Ɏ��XZ��eP�s�#{=��L��x�ٚCA�M����z�>1�r�ʠp&T��zsM�(��,���
�,�{����b��`���#�(���¡�D�t�[p����T�fh�JmK@,�6����P�S���5�X�XU�<�T�f@kf��א�J��AZ�;=����H/7�hR2vZ��塠��E����F�eQ�'N��
��CAT��i����ᘬ4�	���CAO��i֠Ft�P�pX��
��|�O7��?�pL2�b��P�S���6Ճ�+�5W������
>���b��0��CAO���|���-��4����
>-Y����xl�`�
z*��Ē��/�״ 0v�����OK���2O���R/�(����4ڢ"�бe\B)�T�gi���u�ՅS�(�`��5Ճ�bPN�z�P���`Ϫ�rGN���+�g9�Y7��b��P�S��m39�)9F'9��5��Z)��r*]�����y�T��J_��l"M��↋-��� M���Hz�+�W�����7�yPW�1w`���� i����d�-^���8,/�/������q��~ꯤq�p�ҫf�p1����ː�GB����惖���㐇�}w�������߶��4�����F3�ľvس�a@ӯQ F������G������-����癸׊��CQ��+�B3#���t�g��*�uns��Y�LքPbN:����=k��� ��eP��s��v6�m��MSr��Y�]H�͵Rfi7;G��*� 9�"n���nI��,�����S�j_hBKa�Ƽd��(��"ۃ��l���^ގ
ђ��Z�l�i�P�Ӥ�lE��z��E�������n���n4��US&[.��,BA�!���D��
��k:�-.x�E~�׾J,�>ci���
��}�{�o�k�f�{��E��U�s(���-����XS�8�J_����_�Wg�}̾(G'��\�@?C�n�L��[l�Ӧ
�`��$۽�e���x��\���h����cZM_q��AA'��h�g������dH�/����[�Yq�f������vX�jDr��E��#����)m�����;����g��;����ѯ?�3�^�:f�ڟ�jˠ �>��^�]��*�ӨB��]����CA�$���~�-ë��4i'-g����b��P!���\�����ePЈa�[V|���N�)U�q�MaD�P`�dsp�$z��Ѓ�z^^���� �fƔA�א����y�C�h��[̴�Z�
̖<�u��=��O04j�:���[�r�mH��G~b��
��Q���P�_e���`�
���OcYd�i����	1s%H��!���ٷ�ʮ�ճf�t�l�b�S�J��+Г�z~A�y��{��P�u��m��v9����;�x29F{;�1x�z�ba�-�h%9]���hop�^�u\q҉o]�=�k���i,@�]����MZ�&�h���@Z��&[x��ͤ�A��o6��A2ۀ�7wǎ3�dy(�Y�Ӷ;²a,kB�Q�;$�uHݜT�7 Ŋ�I�o�[�z�يx�P�Z0��
�yh���Gǽ��.�`10P���	����>ES�t�)fYR�]��B��\�6�؁�m�h�>=?���e��:,��,V��J��}������ٯ�Q�~.���Ȭ�f��ɶ7����_ғ���C�0���V��9-��圾 ��qP���q����]��v�]+���8#�b��o^o���{B���|!u�)4,���a-����DZ�
�zaڷ��u!���#'��xx<�e��m��F�=������Z����Cf��a��g�����lB7w����x2:���'}o��U�*�xVk0�,s�L	VT�ҫ�X�u�n�?O���Y��mv�[S��E'�C3~��
����]f$[H�yhF���ߡ������[��[����/1n
�G��K������c�4�݄r粻����5��e��>��D��}�샋��O������t֖!���[����W�      �   7  x���M��8�5�}�1�_Q>DN����C�������m � ��`�|�ʠ�����5R�&�ן�d�5vѭ���d|���{�-������?�X�(~K��c�CN�����ruU_T�C��
��<�$wk�fjϥeĵ�Vە�4)li)E^�#��|n"����jWV-Yn)��ښ7��x��^.�cu�.��ξu1W}����bݹ��5��_��a�b�����]V}���xP�۰�~�mr�~��sP*��ٗ׊��бs�:k�|�k)��9�ݧ��5�Vy������olC[�$�~H'�U�]v��@b'X<�
����uk�Qy瘍�ka���K�粒-��y�X%�j��ƲCXe3�W�u�k��k��+϶��N^��~u��7�,R�0�X�E Xh��pYߘBWV��WXm��|� X`L����ͯ������\�U*w� ��h���j�4&m�i�8������5}j5�Վ�?��7W��C���Ԥ
�jL�ƪs��d����}րaU�aU�~��ϴ��*;4ɟi�r�^{�%P��)�� ��@
�ε<hU��|�jF�<Ŵ:��Մh�*��@�D�F�JL�1ȁV��iI�d�B��#Y���u3}�9�Psr�10��8�TSr �&�@�c�Y@�: Y�8ղ=�d@P�N@P��Y�� ,Ȑc7�9�;����.���\��@!LȐ`�!)�c�� ��G-I��Z'E2p����@�W���+:F���������v����B���xW�x���1��O,v���Km��Z��|�{�VYo\[��
{k?��)���tt�&4G��4�A�A�J��h���*�Áu����V�ݧu�D�Z`Z���.�9�<4�Ar���S8jF����R"YPL��M0���j��|��dP"Yh�Z��JJ[����T_����-�VPM ��6��-�9�,-�yxdv�~�$��(���✳WE�@�@��2F6RǸ��t[7J���c��Zr�q�鼏�uk}]���2ϐ5�ݤ�3d:�	�U$��bn����������>>>�_�Vo      �   Y   x�3�4����,���3��q�s8M�MLM�L8�KҋR�9��uu��,�����M�L,M8�,,8K�b���� ��"      �   �   x����m�0���Z@�H���!2A.I��Q�(zhP���2���A�vr�����G�} �C0�&�|�wdϣ��Gy������?��o9L�d�C埆��ń���ͥ�D�\����2ݹ��1���-�!X��RC����WfWD��'��s��)��W�{5��8��g
�R4s�ʁ���[>O������䔗��w틢�	���      �     x���K�A�u�s�߫^9�'�M�	d2w���xEO`Q�3Tnd��n� ���W_?�Uh������ɟ�����^���+���K�\3��l/������]�l�! \��w��B��dAB�����2�����d���1ȟ*Q	V(��sQ���ޝʬ_�9��?.����.7�����"�	y�zY�z�;vW�[�[��R��o$V� ���P�~����"��B����m���f����w'À�i=o=$��z/4)���X���#��z/6�=�b���E��O�������Q�!4�Ӄ�22�E��z0Y�@0����ԀA���ĄCTAn���u.!����ҀIF�|�0*�6����iAF+���t�*��jk�\U,J?��Q��A}�p�ɹ0��6�`S4�/�Hx\�mT��iP�4R���ĄCT�MӠ�i�[���/�`�4�o��K�4�Q��)[�u����r�x�_��� ��[�"2U�[�W9t�ˉG��F_�;�E�{k��_�7nd      �   �  x���[o�ǟǟ	P-�3ç�/iQ��S�yYJk� E
�(�zr�6.#�sC`'�%�dȶTӒ)��o�33KΒK����0����?�ը9H�Z��v�0�h�mE㤗���}������tK�-F�p={�M��(��緲���4�d��%XNP�,;�?�����~�:��Ϝ�'�f����1(��_V���[	�r�7�P<��JS��}��@S�E���Np��`��*�$d����k��A����[,N�X���us����I~e?����yO/-���(��(fD29�:I3�	�b({ _��;��GΜ�}���*��B&�C�x4h���v+�u�� q ��'����bj�e�-ԛ�H&�D�e"�q�����x�S�M�;��'�P��5
��+�{���_ �%�e��?���䟛O�w��X�6�4��Ӑ��p���i0݈���c �(g.پ3d�T� ��R�m�YĘ��g�)q�!Ps<�k&�5Q��<7^?�8�I~l3���xT�#���RFo��8����e����
	�͊��͟W��{�m�yJ��b���ukƃ&"Q����
���afvŰ�ͯW�hl�AY$�"�Re��P���uå�}VaȪ��U~��?+����<���ұfA!�>���4��h4���K>��?��	�"ҏE5�����&��d�B�7G�DF�U����"A�:�d/�9�k�Xx&L�m[�o����b�t�3X�!tġӳ
Y������AE�<�S�$�波OV
h�0S�D70�����ve�#��/��v�ӿT5����8�}��|�FȦN�N!"g�I��)�(�R<`r���� �b�C@�e�LS�	��ʙlEj��`V�R�(��P8j����Zꕾ�@Rf���g �3����M�$a<�bA��V�8���[��	�?B��|�0aPN���9�=�h�TvRd���H��i�1��r�,�T����^��
G���7��S;��Y�:���)�����ef��$ꎚi/�H� I+�/��0-/6��+ӎJC�&$�BqPR���#Q��u۰9��� Þ����L�"SH�,�L�1ϊ�c�U4�L�d��jyZ^09㲑�äl���r3�-f���������e��yx0H��5+��g���J����'K`�0S4?��in�$�Z�����Q��g��ƋL{m2�/fy���� �����L��Bt�<�,�E�ɮ�B��1�I�&yb2�FY��T#c&JꒈǑ�1�A+�\ݠvw�N����6A}_�_ye~
&�����.��?)�b�=c��fJ'���lTM��nn���T8��|jz�E��w��Rca#Œ-R+�EE��]q$t�B��v��p�I�A$�i���߶��B�����%)p��qi��@5��A��6^WDZ�ᙀ���N/Y3ur?��*p	K͉n�����gb��9�XW�e@A�s�X�.3�lw��沑��o�0�g������}�tg
Lj�fRUn5 E�H-is�8i�i8>Ϙ2ur*PE���d (F^�AꞜ�j�XJ�"Ÿ� �E!
��ѴƝP������[�6`�߁�9_���o��(�a����)#���fC�� �վ���LP�c�8��u{��L��"�%�R-e�c�ho4�`�rm��Z��f�7?V%xS�(ᤒM%��]�C�-a�������L�3�2�Z����ҿxQ�ƜZt��\Y6���l��؂��l����6^[��i�J
W �y�C.�ݓX����d��!��"���6�7�&Td�b�GV3<�[r,�7e���H��4wF])�5/.|�jΕ�=٩�����,PK�����Oe�U��ő)��M��l2��|� uaG����zem$b^^H]��T�����Ϣk׮���~      �   �  x���[n#;���Vq6��7�^Ĭ`^�rf�K��J����f�	�h4R�|���OJ�ѷn[k���.m#���������gȯ0�_�O�_.��_�l���P��nԨ���ݨ��Ԕ����������N����q綰*���;W�ф;�]xl�IR>��?����&vc9��xy��&r����f�` ;K���*C�i5TnJ�����Oܨ��bc������3��qy��[ペ���⓽e��wC{���l��7������7��Hm�n���O��U�z�6l7z�b�;p5|��[�Cmx����+�n,�HTc��ܞ{Ϗ���w�+~4c��k&�4���>��Zb.��+v �q$���?a��%T[Q��P5�\���\d��uW���m���VEi|���Ɠ��J;b�6h��	kY+�c�E=�������;U	)��S�$^�~kq�7�U78��K�"�K1�_���tw��U\z_e��8$�A^8��Ď�\�ͥ���:d��p��d<�I�����T1�r�Knܚ=��ӳ��6xY|	�et��O����v\��;��9���K���z�Znn��!�l�=a���"u���wn�HH�0����W'�����oA�n��G<ܖ�����̽/z�T7;�$z����QT��%��k�7��G���E/���w�����ݪ�E�����νǎ�7��ܖ�[���XJms�@e�'.mV���R@"�:
/��3��߮���\�d����~z3U5o�jr��|Sz(d����?W�x-��Kxd��������fI�_H�w�-��8tD�J�H�`�4�BY�su��q����slrJ:����o0��+�%Ez���&O��Y��:���J]6��&�����^(Fw��x� ��2�bouS}`�d�}oA�{�8B]v��ݛ{����6�<�D!8�>q�*�/��=��p[9C�sŷo�\E1:�Y�!���흙�z�ж���fqgp�&q��[l��ݫb�E���%S3�M��=�o����̌�opt�*�Q;���%�(HR�eF/�g��f�v=S}Q��⧧'�7w,�'����好�$�&�e�M��XLK0�1�
$��frvF^S��T���'.�l?c�����7���1[�np_�H2Bg�+�V�)�|���3�e?؆� �ӥs�_nK0��H��4�Ϊ/Z��8[�f�����rv~�(��K0~�
,Y�w,�8G��W+�oj�G��x4!����e�=7·��k�:t�c�y�q�Q�o��!�H�ṿ��Y�j���uʐ`��`i�nvJ;�Zj��+0�l0�:C�r���20-�tkpG��{�R��c�iT�[<;�P����I�ާP,����X� ?wx��A�� ~m��oD�\@?>�j���9�;Z�!Y��'n�ZHux��J�c ��xZ��'v�Y�E	�>{~���1\��8�/�����^�<r4�'6ím�<�l<���-���Ӓ��ۑ��n�j������k˕F5���\h�s�/�׸seJ��(5ޞ��4��W�}�\^r�P��2g�m�CY�<���o��7����������wY�Ǟ���lY���E��n����.�;�pgˡ���ʲm�T���-�H�a�:h�Ǔ��*cc�yU$ЍF���N������p��髐m�
z��6��1/�Wr.:"aw,�=�ц/:�y&��#{3�^�Y~�RƸ�����*�����r������aM�N6r2*�<MW�y���Pi�Վ�?����Z�8�~��ƝۗC,D�~DN{<��wJ�~}�b�E�e��֠6�	Y{����5+m���K�h��m�s� q���Εw�C-7�?����/��!��ĳ��Ҙ:��o!W��4�h6���C�9l�}	�z[_�ь�썎�O�9���'w_����� ݑ��)k����� �fԃU���a�é۴��4Z�jp��8h�恎��g��y{�
F�+,$��R.3j���ߋ:3oX�~ȫA�0�U��A�����~B�Y� ��'yO�y�p��<�9_���d��G�ౣ0���H.��W�T�5��y���)�ѡ�r[|\%�|����ٕ>.���5H��q�!�Kn����qSţ@Q0�4���R�Z,h�<Y�`�p
�YԽ���z��xD·$� G^\����hK �I��]�B�XQNH*X�m�B�/�y��BD��~?0ucI��q�U,�"�̉����<	}�T����Z-�/Vt��$�?��`$�	�Z -�pVDFg蹇Q�%0O����}��e�|E�if�R�>��w/Ֆ{�D)n����P��t�r��fZ�A���ZjyA���qt�T �8�KK4;�H�G��@�H��h-З@�����a��Xn!ϻ���d���o;jC8�f�F-����Ɨ�X��M!����S� �&�5p�pR���/����Ľ�ƽ#���:�6Ľ��=:$9��	��CG*�w`�sn�R���X���7���Xԕ�J#���Ou@_��ET�{���X�v8���D�q��{�9Z8�u봐��낣/���Ո��Me���4hi_�<��R��<!4l(M�P�R/�SI�?�s��R˿�����8}�qz�ʴ-��kE��e�v���-��M�#6N�4T�F?��<9��@=2�z]��XΜ�V:�C���N�`Fb!�	Ӳi�b��璩��~bێa>Ǳ��+�C��+��A4EAH�yEU(q�4YZ�<�F������,=z)�)^g��C,8i����di����<�v��%�fY���C�v���bi�Di^����>�pB	š�M����ca����5[�Z`,`�,4TۼX�봮�50�ySϡZ�~�봮�%0��Q�Ŗ|��L��@T[ �HK �Zw�{(����zܜ��r���Ym���4XQ�Y[�&����H�_\0E��L��J�yaA�+'O��4�<+�ْ�,�fE��])r�č5�><)�� /�3	UG4����z֓�8�#��[)/��	���('�o^4.���н�.�?�;/�7��mͳC�ia;���b�,�H���O���|��ɵ�GK^�CG�_�6/J�_���:RC��E=u�xͳ�������E=��<Hm4g>/��ɓ5/�l�>ɥ��K�(T�p��A-�~^�w��&�Jy(��ɛ׊U��8^77X��K��C��+yc�sԿ@mOKy������%�x�/��Hא���X�l�j7�xyr��̦3������$�Ɋ֡�ח<�V�^��h_� _R�M��hͳ?5�Ky(Go'���w�r��5�����i)O��y��A.y���R���[;�y7�zVm�g��$4��M�� ��
Ɉ��(��j����f��ݙ/Y��W���ҟw�G~�n��J^>��~���_�6v      �      x���͎%�qF�]O1/0	2������ C;ﴑZmC� ���w���&3��\aV#�4��_�1�[�ڏ����_T��Ym�|��Ǐ��o��$�5�����ߟ�������o�ӷ��bK�$H�5�?����C�RhQ�-��r�Ck	1~�%��޵n%K�f�
���`������S����͑X�x�-���oN������_����s��L�wm�H-��,�����?~�������(�b![��7�=ƌ��J��
�
��U�W�	B���d�
�V�+P��RTL�o*�4��z*�ASɦ� U��>�PSi���UE�*��T���TUBݩPVʪ��
uU��v*�����v'?#�9m���������+G�H������p���x}�uӞsw<���]��xs�����@Z r�?m��&�5�K��J��N�����l�ڃ�v�F���p��wM[��������<F}�nQ[M-�
�^Gm�Nxۜ�9?�C�R�O���}L��vt��I��U(>�K�4h�F�{.���L/0��QA��3�d%���Ui9ٱ�ԕ�ųaƛ�4ɚ�x��6^�xͦ������0��"�/w�۱�l�3���N���C�Nx���#�����,�0��,Y�kq��WOڳ����4|n[ז����9_����D�REɛ�b9�(�m�G���NN�#��OɶM
g�g�32F[�����i���x�b����'�ĭi+��� �V�!~����Eg�6Œ�[��AF�]���C��Pxgq̀�=�hO?�P��M���}������܋3��QҴ"��0g�{l���%���A�PY��F �B�f���1��i���F�Ã
�JcY��f,k�i��d�e�1�T�c0[�A��jL[ь�)6�R'�Vu�(��b��A���7T��z��S��thGԣs@k�lm,��|�)1�����'g-�$�*�����)�Y��_,Ѫ�G[�F(�s�;�2��Ʒ4���=�I��M����s�����c_>TeL7A�)�3|�[�-��P��� �|zi�ZߴB�F����w��ۏi�g�r����HK��|\��©&2����p�Sp�}�9�7|��E�#z�q]���	o�]K�`�=���$�rZ}qS�C��^��S=*&O-�.��ny���OÛ%誒��<m��φ��7�b�o=����r˧�?�%����5wy�4��sJQ''��{
[*5�
�vF�L�4��As��	�N-�Zw*�E���v*<��D�F�wD�0�JekY��,Z��� ��`�"�"F�M;��.�2��Y3�8L_Rv,S��}hH��>�4Lc��M�j`"3O�XZ�m0%ɀ�E|˅�m�һ3���
%�YJl�7[�EK̝�Ė�8g��D���!2��q�R��MTs���%j#����j�M��&j�WKmbd6Qˎ�612�hYN���M��&j۱�&Ff��Xj#������%�e*���Te�T�⎥*�2���L��>�Te�Tf&l`�ʄ��~���*��d6���L��>�Te�T�ʎ�*���c����l�*S�235���2e*�a�R�)SY�;��L�ʲ�X�2e*��R�)SY�KU�Le9�X\�c*��R�)SYΖ��1e�~/]q��),W�R}%����JP]͡T[	j˫��a�+��_x��0�J���9��F�(v/�����'��yçfY����J������	ޏ#�kyz�W���\9o�l�櫧� 7-tq.v[JŽ{���C��:�N]8�=�VR)�Mhr]�k�r
�#��t�ec��F�s��)|Y��q�Rϑ��(�c��%�X|c�|G�Q�o�{d�=Jڱ�d�?J��p� ����@�u���+�z#��a��I�J	-���W��
��,���]�w��[�|sC^N}���z]JS�����2�3��-X���A���|s��N��i�Zܕ�r��*���`�V���q�.��g_���bwMrq>�Ů�1=�8�l���N\�K�+����~s5��*c�8��9����"�k.���8���}/,�o�P���Z��=�So�Zm�ǩ�]��l�oa�$Ux\=ӻ����ϿZ�i���2�ޜ=5Ќ[�x���izs����OOR�8�ޝ���Q�5�?�#9\aӻ��������l�p\j��y�s���֤w��knwd����E-�R��y��N�'�`��N�y�F���4�Kߢ�������7�~�������	.�ɍ|����@�,����9���i��g��a~p�N��+���<Ұ���W��Z�rn��;m�j�&/\��k��yX!{{f��H��ɝ|O��r��������b�F��y)�w3v�-|�U�x#�t�������|��^��o:�ym�/���x]��N��6�󙌏�~�F��d>�Q��Z^a||W|��r�?Ų�-��ܽ�R`�nx��	_�C�쿌ٗ����u�t<�7TJ���`��1���Wj��}�������tx,/M�Z��͸�zJ����˷�0Y��3.����9��6柳V����p�?'�6�~sj��+-������l��^s��|\r�7#�rJ��{���Z���^�u뿜{ϻ�6������E�pm;�ٶu/?g�\�����F�O���7f�
v<q3k������C��Gz,��O'��������/�X�f����(w3Iy�M�WO���>t~Λ��>?�����UI~>�|�FSf�n��^r�ؐ�������F�{��K���).N��ϧ���j���}�"^ƌ���S�Y�1lMߦ�~\�X�}�d0|�On��dG?^qM&'�')��n�/���T�8����:�W�j��tҧ-z�����uX���������1:m��אu�6�j�U���~���<ts *~�#.�i�+m����'9?י����:O��V84R3(��\fN��Ƭ�ӂIK�[�F��_Ҕ�o��:/���K��D�җ4OZ?���q;���ǫ	>��?UQ��̟�~$�y�\��%v?�x�~�sV�D�*j�uf�J����Y���NyN�2
�u�����oOe�@u�鷏>ۦ����J�Ϟ�s8��45��t��%5Eˋ�}��luI�ikf�z2*m�)�Zn�E���rnF�]5=����igL�t��Nn�������E���{~\e��G;ZF�o1-��mڥT�:��T;X!��V���.��c��`������/k����o	�5�o�Y�gP���shON�d&Ш���%շ�w1*�
(GaM�A������Ӏ%/4�ݴ��h���z��֨��bɱ:X	�QMY��TV�(`�B�ӯUF�H��Q�i_����ՑH{Z�`e΢�(צ�G��Y#��P�{�+d�����o=Cݒ������ݠfVz̥�I�eyr����yJ4�[kڢ��B�������y��ͯRݦ��N�%�%U떺?�iT<�K���B�D��x�,?4�~�#���,B���g �l��2�+A=��H�u��/T¸Lɱ'��i9?Ǜ�虈{_rx���qk���.�;^� x��7�t��*ntI��I�g�Q_-���J�N>jB���\R�xe�$��6��;Y�C�z�����W{jf:����ܳ����IMH܌�+�V[�kX܌��X3�R�-�MqWJ��Ҝ��	�U5U�N�*Rۮ�b�
������LM�:&���g[��7c�;MR\�Tꗘ~���&題z��U�0��j�޻U�Ib�� �b��HܻٟG�2Z�$����2vN��MD��-M�R�]����}��'=���>O{k�ϲ���H�>���:G�7^N��t��{�[-e�P�������y �����ASܻ�OG�[<�7ۗMP�cA�F�f�ݱ��<��ѴR��v���e���|"�6��43���l&�"~z�ԏu���"�����Q�G]jn&zz��ϟ�$��iZ���c�iN��Α��hTf��S|��Q�Ž3�p���IX��A��[�c�	��hxvD��-�����%�r��$?�x咚��wos+mep��/t���H��[��D� T  c�Œ��������?"qS~~^�2�6����\2�gp�]%j"b��x/Y��,K����֟��k�s��-xJ�����G�䘎���Y�Tլ^�����ϕ����B'���a�3��7&������2�G$TxnPt|��2�O�����]Gw���Jc6;ZN�}�!�g+}@���X�T�VTCU���vo�'$~&m�N|՛q5�E��N�\��#?��ܙ�8k�z��٧�N��&$m�[����fN���v�ioC_�68�Ӧ��V��6�<�
k�ϧZ7,��nCGy�T��hw������wM޷�h��<ǎZd�gmoi��O<=��m�瘃7����gB���<7�Iܲ�Ҩ���˨�Q���;�Oo�} V6��)���]�y���FKu��++��~�jQ0�4�Ǜk�����'�	�9^���� �ٔZ���p�GZ�x԰/�uܶ�M�&9V`����K�/n7|f���c���?p��vcB�Q�Es������6	�Ǎ���P����?����)oÈ�r��}k��eS�n�+X�>�J��v��8�EpU��ț1mo�����X\B�<f��R��j��a�U�l��Z~�ԥ�9Ny8��8��ɖS��,��ԥ8����������������ɷ\���NspZqYP�5$��S�����h�ӥ9�X��MJ�ؽSS�T��2=s�}�^�`����@τaɂ�T�I�m�6�ͬW��0&��0��<���8��1�EG�M7b�寎Z�̕�bThМ���'�^.&]�7��=�^K�`�G4�gKS��y��cZ�<F���w�]�����8-Nq�-�fA/KV���{�0����C���X�#���:��5�)F��8�C| S�4��]�7��Cϩ�z�<�m���'#;WƤp���������'6��s3�Ś���y|�����K�|`Sc�W�B��jk*o>�ͱh�hj,��X��-9�Z�L��M�7���V��ȶ�]�ƥ��D���r?������� ݸ�N�\���ڌy�b��)���2.��،�MmFYٌ���Z5��N�
�G6�Ȟ�\}pŜ�!�]�)Y!��T�Of�>�Z�\jM�9f����#��SR]���j���i=űdɏh��Ӑ�y�y����8:�����'6�tu�G=0�T�;W�N<8������n'�X�ߍ��?:N�\���Z���27y�]+�S�v}�5?�i'|j+f�tӶs���Ħl+4k�47F��ܱ�%�T�m����ƈF����۹d�6U`[)��|gKǉÕ�F8���J��'���]����Qǒ%?�q�e~r�b�yt:ۿu.�_'���T���i���T�?E�J��^�Ħ
�+VWI��_�	�dԉ �h�����bŦ�^�K�-�E�N�7��HuX�o<M�}�fp�Tu <�#����Ś=%�=f�f+m�t.Y�M_�+�QkM$:�������t�|pE6��/Jb���5�tJ<�4����^���"��s,Y�'����$��F��M,�+o�^�;]t=����������m��8��	�/W��/�{J�/�蠻cɊ��T�n����R�[����[�#_�n����j)� gB���h��J|o�O*~A��KV����XW��}|��n�N�٪�K��N�&]��[J�W;:��u,�[}DS����W�b���%3U��wDS{<��^�x<���R{������`g׫J~�{qo������sQ㑍��U%��,Q�T�m�w.*b<�q}k%���D�J90�_#�;��qn��\�����;׷�y�ظ������KM���T���sQ�呍��˸%O=�-w.�c<�q�����9�Ľ��N���h\�Z)prg)�x~M'ΝK���ƭ/�H�U����O��N8�q�k���*�`V߱��ExD��z���~�RҨ����ob��z���"�Q�z �Ǣ"�׷V�k�;�E�{=׷���l�M��̃|�FږjH�9׷��&6�o��׼�#����#��yo�E���]|�,�j�W���u�Z�b�M_�K�+	W�{������:����Ɖ��~�6���?���yD�DmU���6��/n����h�����Ub�����aqk4��G4U��������dg_4+��?�q�+���O���5�`b6�hѦՍQoj�<���m"FG4n>_Y
���Z�O�v��$b)�h�̽����Q�1�y<��$��#�s�t��m%�8&p;7����*2�B��b-�������w�)���G_m�f��U�cQ��wr��'㫱��^�9�sIc�{�W^z|�<T��F��.;�������+��x�2��u-z��\4����7�)�nj���BzU�\ԁ��Ɲ�+���DK������쏿}��?���wǶ9@.�b��^s,���;����?a�X-��?a��Z<R���g�a��C���&����3������aӎ���LeX<��TfN��[�3)������|��Rw,N��~bqOTY۱/~�LM2�E�W����TV͂e�������=1LeU�M��0LeUO�S�z��jڱ���TV�8	x^_��,WiŰ/y��}����m��	TY�7��@�������f6��T��,�r,�ET��,��g*3/6�xD���d;����T��}����fj�a_(� l��Z�G@I��!���6e���?$Y�(aO���}b�	�UޞF�v�ڽ��c�B������Wr��k�iLa_\H����SثZC�^����	�>��Z�Ħ���W4?�I7�*�%�}G%|d7|?��mI4��J-s�X\��N��X|� �h��n'�Dbq�:�>6��f�D{ر�fȜ���X6'��3s�]���,SY�}��v����o�ʺ������DֳS��f�IŁ	�X/cc���ңa�����}��mck_���*����v*�; ��[a�XQ}96��� �듊� 
ЗSel��@`�U�H���
����d �96훀�� {���z
��}��)@b�-;��Pc?�8d��;��E�cq_J�*3S���sPe}_-�`*�ձxZ����°��}o_x�,a*��c�TS�1�YR:�x֌�,����H4��,��`*�y������X<�Uf�6��y��;��WP^�����c��TY߱xp��'O�1�ٿ�g�q�Wg*���	�2�;X0�}`��S�Ȏ}a�a��þ��	¦}�x��L̂U��� ��,b*���-��*�c��A���X��VsL�ͺ�5,�ed�iBS�z=&�/q�����m]���	M}�j�*�
���x鸵��]Mh�޵zĢ�o��Sɰ���<bqD���=cfU5��{�-^䉞#7S�������_h��&4�zd�N��vF�c�;�7zE2�wD��R�Zq�-�Z�cqK%��{Dǀ�;�?���4�2���Ҍ?�q�l5��K�9zs�s_����{ٸ�,�n7�X
;��
E&K�l|XW#����?a��*9�ظ4���>��|�}pqm���ؑ:���>����,�%���1���I��v��}��������T��     