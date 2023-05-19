//package br.com.cod2d.api.gateway.impl.repository.jpa.seed;
//
//import br.com.cod2d.api.domain.model.Funcao;
//import br.com.cod2d.api.domain.model.LinkGs1;
//import br.com.cod2d.api.domain.model.Organization;
//import br.com.cod2d.api.domain.model.Product;
//import br.com.cod2d.api.domain.model.QuantidadeLimites;
//import br.com.cod2d.api.gateway.impl.repository.jpa.FuncaoRepository;
//import br.com.cod2d.api.gateway.impl.repository.jpa.LimitesRepository;
//import br.com.cod2d.api.gateway.impl.repository.jpa.LinkRepository;
//import br.com.cod2d.api.gateway.impl.repository.jpa.OrganizationRepository;
//import br.com.cod2d.api.gateway.impl.repository.jpa.ProductRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.Optional;
//import java.util.UUID;
//
//@Slf4j
//@Component
//public class DatabaseSeeder {
//
//    private final OrganizationRepository organizationRepository;
//    private final LimitesRepository limitesRepository;
//    private final FuncaoRepository funcaoRepository;
//    private final ProductRepository productRepository;
//    private final LinkRepository linkRepository;
//
//    private final static String ADMIN = "admin";
//
//
//    @Autowired
//    public DatabaseSeeder(
//            final OrganizationRepository organizationRepository,
//            final FuncaoRepository funcaoRepository,
//            final LimitesRepository limitesRepository,
//            final ProductRepository productRepository,
//            final LinkRepository linkRepository) {
//        this.organizationRepository = organizationRepository;
//        this.funcaoRepository = funcaoRepository;
//        this.limitesRepository = limitesRepository;
//        this.productRepository = productRepository;
//        this.linkRepository = linkRepository;
//    }
//
//    @EventListener
//    public void seed(final ContextRefreshedEvent event) {
//        seedExampleTable();
//    }
//
//    private void seedExampleTable() {
//        final Optional<Organization> orgExists = organizationRepository.findByCnpj("99999999000199");
//        if (orgExists.isEmpty()) {
//            final QuantidadeLimites limite = QuantidadeLimites.builder()
//                    .qtdeLinks(200L)
//                    .qtdeProdutos(200L)
//                    .creationDate(new Date())
//                    .build();
//            limitesRepository.save(limite);
//
//            final Organization org = Organization.builder()
//                    .name("Empresa Padrão")
//                    .shortName("empresa")
//                    .creationDate(new Date())
//                    .linkSite("http://example.com")
//                    .linkSac("http://example.com/atendimento")
//                    .linkLogotipo("http://test.com")
//                    .fantasia("empresa")
//                    .cnpj("99999999000199")
//                    .limites(limite)
//                    .build();
//            organizationRepository.save(org);
//
//            limite.setOrganization(org);
//            limitesRepository.save(limite);
//
//            final Funcao funcaoBasica = Funcao.builder()
//                    .name("usuario")
//                    .guardName("api")
//                    .build();
//            funcaoRepository.save(funcaoBasica);
//
//            final Funcao funcao = Funcao.builder()
//                    .name(ADMIN)
//                    .guardName("api")
//                    .build();
//            funcaoRepository.save(funcao);
//
//            final UUID currentUuid = UUID.randomUUID();
//            log.info("current uuid : {}", currentUuid);
//
//            final Product product = Product.builder()
//                    .uuid(currentUuid)
//                    .brand("nestle")
//                    .fullDescription("Achocolatado Nescau")
//                    .organization(org)
//                    .unidade("UN")
//                    .gtinEan("12365465454")
//                    .pesoBruto(1L)
//                    .pesoLiq(1L)
//                    .metaTagKeywords("nescau")
//                    .metaTagDescription("nescau")
//                    .height(1L)
//                    .width(1L)
//                    .sku("321654")
//                    .length(1L)
//                    .observacao("observacao")
//                    .internalCode(654654L)
//                    .enabled(true)
//                    .processed("N")
//                    .description("Nescau")
//                    .build();
//            productRepository.save(product);
//
//            final LinkGs1 link = LinkGs1.builder()
//                    .uuid(currentUuid)
//                    .urlRedirect("https://cod2d.com.br/produto-tal")
//                    .urlGs1("https://cd2.io/empresa/01/0123456789123")
//                    .urlSiteProduto("https://empresa.com.br")
//                    .linkName("GS1 Digital Link")
//                    .product(product)
//                    .enabled(true)
//                    .creationDate(new Date())
//                    .linkDefault(true)
//                    .pathOrg("empresa")
//                    .stringRedirectTo("https://cod2d.com.br/produto-tal")
//                    .stringRedirectFrom("/empresa/01/0123456789123")
//                    .build();
//            linkRepository.saveAndFlush(link);
//
//        }
//    }
//}
